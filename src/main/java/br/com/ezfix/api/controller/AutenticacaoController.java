package br.com.ezfix.api.controller;

import br.com.ezfix.api.config.security.TokenService;
import br.com.ezfix.api.controller.form.AssistenciaForm;
import br.com.ezfix.api.controller.form.CadastroForm;
import br.com.ezfix.api.controller.form.LoginForm;
import br.com.ezfix.api.controller.form.SolicitanteForm;
import br.com.ezfix.api.controller.dto.TokenDto;
import br.com.ezfix.api.model.Perfil;
import br.com.ezfix.api.repository.*;
import br.com.ezfix.api.util.PilhaObj;
import br.com.ezfix.api.util.Reveter;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

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

    PilhaObj<Reveter> pilhaObj = new PilhaObj<>(10);

    @PostMapping
    public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm loginForm) {
        try {
            Authentication authentication = authenticationManager.authenticate(loginForm.converter());
            String token = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(403).build();
        }
    }

    @PostMapping("/novoSolicitante")
    public ResponseEntity<?> novoSolicitante(@RequestBody SolicitanteForm solicitanteForm) throws IOException {

        converterForm(solicitanteForm, perfisRepository.getById(1l));
        solicitanteForm.converterSolicitante();

        if (usuarioRepository.existsById(solicitanteForm.getEmail())) {
            return ResponseEntity.status(409).body("Email já cadastrado por favor faça o login");
        }

        if (solicitanteRepository.existsById(solicitanteForm.getCpf())) {
            return ResponseEntity.status(409).body("Cpf já cadastrado por favor faça o login");
        }

        try {
            usuarioRepository.save(solicitanteForm.getUsuarios());
            salvaEstado(usuarioRepository, solicitanteForm.getUsuarios().getEmail());
            if (!enderecoGeralRepository.existsById(solicitanteForm.getCep())) {
                enderecoGeralRepository.save(solicitanteForm.getEnderecosGeral());
                salvaEstado(enderecoGeralRepository,solicitanteForm.getEnderecosGeral().getCep());
            }
            enderecoEspecificoRepository.save(solicitanteForm.getEnderecoEspecifico());
            salvaEstado(enderecoEspecificoRepository, enderecoEspecificoRepository.findFirstByOrderByIdDesc().getId());
            solicitanteForm.getSolicitante().setPerfil(FileUtils.readFileToByteArray(
//                    new File("/opt/ezfix/blank-profile-picture-973460_960_720.webp")));
                    new File("src/main/resources/blank-profile-picture-973460_960_720.webp")));
            solicitanteRepository.save(solicitanteForm.getSolicitante());
            salvaEstado(solicitanteRepository,solicitanteForm.getSolicitante().getCpf());
        } catch (Exception e) {
            while (!pilhaObj.isEmpty()) {
                pilhaObj.pop().revert();
            }
            e.printStackTrace();
            return ResponseEntity.status(400).build();
        }


        return ResponseEntity.status(201).build();
    }

    @PostMapping("/novaAssistencia")
    public ResponseEntity<?> novaAssistencia(@RequestBody AssistenciaForm assistenciaForm) throws IOException {

        converterForm(assistenciaForm, perfisRepository.getById(2l));
        assistenciaForm.converterRepresentantes();
        assistenciaForm.converterAssistencias(planosRepository.getById(assistenciaForm.getPlano()));

        if (usuarioRepository.existsById(assistenciaForm.getEmail())) {
            return ResponseEntity.status(409).body("Email já cadastrado por favor faça o login");
        }

        if (representanteRepository.existsById(assistenciaForm.getDocumento())) {
            return ResponseEntity.status(409).body("Documento já cadastrado por favor faça o login");
        }

        try {
            usuarioRepository.save(assistenciaForm.getUsuarios());
            salvaEstado(usuarioRepository, assistenciaForm.getUsuarios().getEmail());
            if (!enderecoGeralRepository.existsById(assistenciaForm.getCep())) {
                enderecoGeralRepository.save(assistenciaForm.getEnderecosGeral());
                salvaEstado(enderecoGeralRepository, assistenciaForm.getEnderecosGeral().getCep());
            }
            representanteRepository.save(assistenciaForm.getRepresentantes());
            salvaEstado(representanteRepository, assistenciaForm.getRepresentantes().getDocumento());
            enderecoEspecificoRepository.save(assistenciaForm.getEnderecoEspecifico());
            salvaEstado(enderecoEspecificoRepository, enderecoEspecificoRepository.findFirstByOrderByIdDesc().getId());
            assistenciaForm.getAssistencias().setPerfil(FileUtils.readFileToByteArray(
//                    new File("/opt/ezfix/blank-profile-picture-973460_960_720.webp")));
                    new File("src/main/resources/blank-profile-picture-973460_960_720.webp")));
            assistenciaRepository.save(assistenciaForm.getAssistencias());
            salvaEstado(assistenciaRepository, assistenciaRepository.findFirstByOrderByIdDesc().getId());
        } catch (Exception e) {
            while (!pilhaObj.isEmpty()) {
                pilhaObj.pop().revert();
            }
            e.printStackTrace();
            return ResponseEntity.status(400).build();
        }

        return ResponseEntity.status(201).build();
    }

    private void salvaEstado(JpaRepository repository, Object id) {
        pilhaObj.push(new Reveter(repository, id));
    }

    private void converterForm(CadastroForm cadastroForm, Perfil perfil) {
        cadastroForm.converterUsuarios(perfil);
        cadastroForm.converterEnderecosGeral();
        cadastroForm.convverterEnderecoEspecifico();
    }
}
