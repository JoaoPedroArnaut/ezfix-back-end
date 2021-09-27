package br.com.ezfix.api.controller;

import br.com.ezfix.api.config.security.TokenService;
import br.com.ezfix.api.controller.form.AssistenciaForm;
import br.com.ezfix.api.controller.form.CadastroForm;
import br.com.ezfix.api.controller.form.LoginForm;
import br.com.ezfix.api.controller.form.SolicitanteForm;
import br.com.ezfix.api.controller.vo.TokenVo;
import br.com.ezfix.api.model.Enderecos;
import br.com.ezfix.api.model.Planos;
import br.com.ezfix.api.model.Usuarios;
import br.com.ezfix.api.repository.*;
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

    @Autowired
    private PlanosRepository planosRepository;

    @Autowired
    private RepresentanteRepository representanteRepository;

    @Autowired
    private AssistenciaRepository assistenciaRepository;

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

        converterForm(solicitanteForm);
        solicitanteForm.converterSolicitante();

        usuarioRepository.save(solicitanteForm.getUsuarios());
        enderecoRepository.save(solicitanteForm.getEnderecos());
        solicitanteRepository.save(solicitanteForm.getSolicitante());

        return ResponseEntity.ok().build();
    }

    @PostMapping("/novaAssistencia")
    public ResponseEntity<?> novaAssistencia(@RequestBody AssistenciaForm assistenciaForm){

        converterForm(assistenciaForm);
        assistenciaForm.converterRepresentantes();
        assistenciaForm.converterAssistencias(planosRepository.getById(assistenciaForm.getPlano()));

        usuarioRepository.save(assistenciaForm.getUsuarios());
        enderecoRepository.save(assistenciaForm.getEnderecos());
        representanteRepository.save(assistenciaForm.getRepresentantes());
        assistenciaRepository.save(assistenciaForm.getAssistencias());

        return ResponseEntity.ok().build();
    }

    private Integer ultimoEnderecoId(Long cep){
        return enderecoRepository.findAllByEnderecoIdCep(cep).size();
    }

    private void converterForm(CadastroForm cadastroForm){
        cadastroForm.converterUsuarios();
        cadastroForm.converterEnderecos(ultimoEnderecoId(cadastroForm.getCep()));
    }
}
