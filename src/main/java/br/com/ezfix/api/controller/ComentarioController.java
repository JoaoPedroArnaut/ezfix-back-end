package br.com.ezfix.api.controller;

import br.com.ezfix.api.model.Comentario;
import br.com.ezfix.api.repository.ComentarioRepository;
import br.com.ezfix.api.util.FilaObj;
import br.com.ezfix.api.util.PilhaObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @PostMapping
    public ResponseEntity novoComentario(@RequestBody Comentario comentario){
        comentario.setDataComentario(LocalDateTime.now());
        comentarioRepository.save(comentario);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity buscarTodos(){
        return ResponseEntity.ok().body(comentarioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarNovosOrcamentos(@PathVariable Long id){
        List<Comentario> comentarios = comentarioRepository.findAllByAssistenciaId(id);

        comentarios = comentarios.stream().sorted(Comparator.comparing(Comentario::getDataComentario)).collect(Collectors.toList());
        PilhaObj<Comentario> pilhaObj = new PilhaObj<>(comentarios.size());

        for (Comentario c : comentarios){
            pilhaObj.push(c);
        }
        if(comentarios.isEmpty()){
            return ResponseEntity.status(204).build();
        }


        return ResponseEntity.ok().body(pilhaObj);

    }
}
