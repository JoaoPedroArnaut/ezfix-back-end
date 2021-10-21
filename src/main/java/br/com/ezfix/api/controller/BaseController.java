package br.com.ezfix.api.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public abstract class BaseController {

    public abstract ResponseEntity buscarTodos(Pageable paginacao);

    public abstract ResponseEntity apagar(Long id);
}
