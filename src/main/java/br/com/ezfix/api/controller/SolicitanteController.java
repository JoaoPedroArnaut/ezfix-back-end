package br.com.ezfix.api.controller;

import br.com.ezfix.api.controller.dto.SolicitanteDto;
import br.com.ezfix.api.repository.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solicitante")
public class SolicitanteController {

    @Autowired
    private SolicitanteRepository solicitanteRepository;

    @GetMapping
    public ResponseEntity<Page<SolicitanteDto>> buscarTodos(@PageableDefault(page = 0,size = 10) Pageable paginacao) {
        return ResponseEntity.ok().body(SolicitanteDto.converter(solicitanteRepository.findAll(paginacao)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity apagar(@PathVariable String id) {
        if(solicitanteRepository.existsById(id)){
            solicitanteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(404).build();
    }
}
