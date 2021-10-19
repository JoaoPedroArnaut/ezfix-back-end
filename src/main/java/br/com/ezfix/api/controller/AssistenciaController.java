package br.com.ezfix.api.controller;

import br.com.ezfix.api.controller.dto.AssistenciaDto;
import br.com.ezfix.api.model.Assistencia;
import br.com.ezfix.api.repository.AssistenciaRepository;
import br.com.ezfix.api.repository.ServicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assistencia")
public class AssistenciaController extends baseController{

    @Autowired
    private AssistenciaRepository assistenciaRepository;

    @Autowired
    private ServicosRepository servicosRepository;

    @GetMapping
    @Override()
    public Page<AssistenciaDto> buscarTodos(@PageableDefault(page = 0,size = 10) Pageable paginacao) {
        return AssistenciaDto.converter(assistenciaRepository.findAll(paginacao));
    }

    @PutMapping("/{id}/{servico}")
    public ResponseEntity<?> adicionaServico(@PathVariable Long id, @PathVariable Long servico){
        Assistencia assistencia = assistenciaRepository.findById(id).get();
        assistencia.getTipoServicos().add(servicosRepository.getById(servico));
        assistenciaRepository.save(assistencia);
        return ResponseEntity.ok().build();
    }
}
