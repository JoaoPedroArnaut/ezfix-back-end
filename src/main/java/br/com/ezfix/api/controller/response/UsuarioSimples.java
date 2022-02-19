package br.com.ezfix.api.controller.response;

import javax.validation.constraints.NotNull;

public class UsuarioSimples {

    private String cpf;
    private String nome;

    public UsuarioSimples(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
}
