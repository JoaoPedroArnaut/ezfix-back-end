package br.com.ezfix.api.controller;

import br.com.ezfix.api.config.security.TokenService;
import br.com.ezfix.api.controller.form.AssistenciaForm;
import br.com.ezfix.api.controller.form.CadastroForm;
import br.com.ezfix.api.controller.form.LoginForm;
import br.com.ezfix.api.controller.form.SolicitanteForm;
import br.com.ezfix.api.controller.dto.TokenDto;
import br.com.ezfix.api.model.Perfil;
import br.com.ezfix.api.repository.*;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

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
    private EnderecoGeralRepository enderecoGeralRepository;

    @Autowired
    private PlanosRepository planosRepository;

    @Autowired
    private RepresentanteRepository representanteRepository;

    @Autowired
    private AssistenciaRepository assistenciaRepository;

    @Autowired
    private PerfisRepository perfisRepository;

    @Autowired
    private EnderecoEspecificoRepository enderecoEspecificoRepository;

    @PostMapping
    public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm loginForm){
        try {
            Authentication authentication = authenticationManager.authenticate(loginForm.converter());
            String token = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new TokenDto(token,"Bearer"));
        }catch (AuthenticationException e){
            return ResponseEntity.status(403).build();
        }
    }

    @PostMapping("/novoSolicitante")
    public ResponseEntity<?> novoSolicitante(@RequestBody SolicitanteForm solicitanteForm) throws IOException {

        converterForm(solicitanteForm,perfisRepository.getById(1l));
        solicitanteForm.converterSolicitante();
        
        if(usuarioRepository.existsById(solicitanteForm.getEmail())) {
            return ResponseEntity.status(409).body("Email já cadastrado por favor faça o login");
        }

        if(solicitanteRepository.existsById(solicitanteForm.getCpf())){
            return ResponseEntity.status(409).body("Cpf já cadastrado por favor faça o login");
        }

        usuarioRepository.save(solicitanteForm.getUsuarios());
        if(!enderecoGeralRepository.existsById(solicitanteForm.getCep())){
            enderecoGeralRepository.save(solicitanteForm.getEnderecosGeral());
        }
        solicitanteForm.getSolicitante().setPerfil(FileUtils.readFileToByteArray(
                new File("src/main/resources/blank-profile-picture-973460_960_720.webp")));
        enderecoEspecificoRepository.save(solicitanteForm.getEnderecoEspecifico());
        solicitanteRepository.save(solicitanteForm.getSolicitante());

        return ResponseEntity.status(201).build();
    }

    @PostMapping("/novaAssistencia")
    public ResponseEntity<?> novaAssistencia(@RequestBody AssistenciaForm assistenciaForm) throws IOException {

        converterForm(assistenciaForm,perfisRepository.getById(2l));
        assistenciaForm.converterRepresentantes();
        assistenciaForm.converterAssistencias(planosRepository.getById(assistenciaForm.getPlano()));

        if(usuarioRepository.existsById(assistenciaForm.getEmail())) {
            return ResponseEntity.status(409).body("Email já cadastrado por favor faça o login");
        }

        if(representanteRepository.existsById(assistenciaForm.getDocumento())) {
            return ResponseEntity.status(409).body("Documento já cadastrado por favor faça o login");
        }


        usuarioRepository.save(assistenciaForm.getUsuarios());
        if(!enderecoGeralRepository.existsById(assistenciaForm.getCep())){
            enderecoGeralRepository.save(assistenciaForm.getEnderecosGeral());
        }
        representanteRepository.save(assistenciaForm.getRepresentantes());
        assistenciaForm.getAssistencias().setPerfil(FileUtils.readFileToByteArray(
                new File("src/main/resources/blank-profile-picture-973460_960_720.webp")));
        enderecoEspecificoRepository.save(assistenciaForm.getEnderecoEspecifico());
        assistenciaRepository.save(assistenciaForm.getAssistencias());

        return ResponseEntity.status(201).build();
    }

    private void converterForm(CadastroForm cadastroForm, Perfil perfil){
        cadastroForm.converterUsuarios(perfil);
        cadastroForm.converterEnderecosGeral();
        cadastroForm.convverterEnderecoEspecifico();
    }
}
