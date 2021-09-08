package br.com.ezfix.api.controller;

import br.com.ezfix.api.controller.vo.ClienteVo;
import br.com.ezfix.api.model.Cliente;
import br.com.ezfix.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController extends baseController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/todos")
    public Page<ClienteVo> buscarTodos(@PageableDefault(page = 0,size = 1) Pageable paginacao) {
        return ClienteVo.converter(clienteRepository.findAll(paginacao));
    }
}
