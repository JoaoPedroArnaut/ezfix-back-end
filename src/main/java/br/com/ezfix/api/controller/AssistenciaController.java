package br.com.ezfix.api.controller;

import br.com.ezfix.api.controller.vo.AssistenciaDto;
import br.com.ezfix.api.model.Assistencias;
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
        Assistencias assistencias = assistenciaRepository.findById(id).get();
        assistencias.getTipoServicos().add(servicosRepository.getById(servico));
        assistenciaRepository.save(assistencias);
        return ResponseEntity.ok().build();
    }
}
