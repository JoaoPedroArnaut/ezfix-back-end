package br.com.ezfix.api.controller;

import br.com.ezfix.api.controller.vo.AssistenciaVo;
import br.com.ezfix.api.repository.AssistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assistencia")
public class AssistenciaController extends baseController{

    @Autowired
    private AssistenciaRepository assistenciaRepository;

    @GetMapping
    @Override()
    public Page<AssistenciaVo> buscarTodos(@PageableDefault(page = 0,size = 10) Pageable paginacao) {
        return AssistenciaVo.converter(assistenciaRepository.findAll(paginacao));
    }
}
