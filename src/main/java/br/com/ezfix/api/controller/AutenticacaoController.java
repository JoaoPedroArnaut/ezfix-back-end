package br.com.ezfix.api.controller;

import br.com.ezfix.api.config.security.TokenService;
import br.com.ezfix.api.controller.form.LoginForm;
import br.com.ezfix.api.controller.form.SolicitanteForm;
import br.com.ezfix.api.controller.vo.TokenVo;
import br.com.ezfix.api.model.Enderecos;
import br.com.ezfix.api.model.Usuarios;
import br.com.ezfix.api.repository.EnderecoRepository;
import br.com.ezfix.api.repository.SolicitanteRepository;
import br.com.ezfix.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SolicitanteRepository solicitanteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping
    public ResponseEntity<TokenVo> autenticar(@RequestBody @Valid LoginForm loginForm){
        try {
            Authentication authentication = authenticationManager.authenticate(loginForm.converter());
            String token = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new TokenVo(token,"Bearer"));
        }catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/novoSolicitante")
    public ResponseEntity<?> novoSolicitante(@RequestBody SolicitanteForm solicitanteForm){

        Usuarios usuarios = solicitanteForm.converterUsuarios();
        Enderecos enderecos = solicitanteForm.converterEnderecos(ultimoEnderecoId(solicitanteForm.getCep()));

        usuarioRepository.save(usuarios);
        enderecoRepository.save(enderecos);
        solicitanteRepository.save(solicitanteForm.converterSolicitante(usuarios,enderecos));

        return ResponseEntity.ok().build();
    }

    private Integer ultimoEnderecoId(Long cep){
        return enderecoRepository.findAllByEnderecoIdCep(cep).size();
    }
}
