package br.com.ezfix.api.controller;

import br.com.ezfix.api.config.security.TokenService;
import br.com.ezfix.api.controller.response.SistemaAvaliacao;
import br.com.ezfix.api.model.Comentario;
import br.com.ezfix.api.repository.SolicitanteRepository;
import br.com.ezfix.api.util.PilhaObj;
import br.com.ezfix.api.repository.ComentarioRepository;
import br.com.ezfix.api.repository.AssistenciaRepository;
import br.com.ezfix.api.model.Assistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private AssistenciaRepository assistenciaRepository;

    @Autowired
    private SolicitanteRepository solicitanteRepository;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity novoComentario(@RequestHeader(value = "Authorization") String token,@RequestBody Comentario comentario){
        String cpf = solicitanteRepository.getCpfByEmail(tokenService.getIdUsuario(token.substring(7)));
        comentario.setSolicitante(solicitanteRepository.getById(cpf));

        comentarioRepository.save(comentario);

        List<SistemaAvaliacao> sistemaAvaliacaos = comentarioRepository.apenasAsAvaliacoes(comentario.getAssistencia().getId());
        Double notaTotal = .0;
        for (SistemaAvaliacao s : sistemaAvaliacaos){
            notaTotal += s.getAvaliacao();
        }
        notaTotal /= sistemaAvaliacaos.size();

        Assistencia assitencia = assistenciaRepository.findById(comentario.getAssistencia().getId()).get();
        assitencia.setAvaliacao(notaTotal);
        assistenciaRepository.save(assitencia);

        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity buscarTodos(){
        return ResponseEntity.ok().body(comentarioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarNovosOrcamentos(@PathVariable Long id){
        if(!assistenciaRepository.existsById(id)){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok().body(comentarioRepository.SomenteNecessaario(id));

    }
}
