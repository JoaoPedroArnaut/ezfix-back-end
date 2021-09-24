package br.com.ezfix.api.controller;

import br.com.ezfix.api.config.security.TokenService;
import br.com.ezfix.api.controller.form.LoginForm;
import br.com.ezfix.api.controller.form.SolicitanteForm;
import br.com.ezfix.api.controller.vo.TokenVo;
import br.com.ezfix.api.controller.vo.UsuarioVo;
import br.com.ezfix.api.model.Endereco;
import br.com.ezfix.api.model.Solicitante;
import br.com.ezfix.api.model.Usuario;
import br.com.ezfix.api.model.compositekeys.EnderecoId;
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
import java.util.Arrays;

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
    public String novoSolicitante(@RequestBody SolicitanteForm solicitanteForm){
        Usuario usuario = new Usuario(solicitanteForm.getEmail(),new BCryptPasswordEncoder().encode(solicitanteForm.getSenha()));
        Endereco endereco = new Endereco(new EnderecoId((enderecoRepository.count() + 1),solicitanteForm.getCep()),solicitanteForm.getNumero(),solicitanteForm.getComplemento());
        usuarioRepository.save(usuario);
        enderecoRepository.save(endereco);
        solicitanteRepository.save(new Solicitante(solicitanteForm.getCpf(),
                solicitanteForm.getNome(),
                solicitanteForm.getDataNascimento(),
                solicitanteForm.getSexo(),
                solicitanteForm.getTelefonePrimario(),
                solicitanteForm.getTelefoneSecundario(),
                usuario,
                Arrays.asList(endereco)));
        return "Novo Solicitante Cadastrado";
    }
}
