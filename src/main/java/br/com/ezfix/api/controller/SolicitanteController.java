package br.com.ezfix.api.controller;

import br.com.ezfix.api.controller.dto.SolicitanteDto;
import br.com.ezfix.api.repository.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/solicitante")
public class SolicitanteController extends baseController {

    @Autowired
    private SolicitanteRepository solicitanteRepository;

    @GetMapping
    public Page<SolicitanteDto> buscarTodos(@PageableDefault(page = 0,size = 10) Pageable paginacao) {
        return SolicitanteDto.converter(solicitanteRepository.findAll(paginacao));
    }
}
