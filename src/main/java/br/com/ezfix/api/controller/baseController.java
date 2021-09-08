package br.com.ezfix.api.controller;

import org.springframework.data.domain.Pageable;

public abstract class baseController {

    public abstract Object buscarTodos(Pageable paginacao);
}
