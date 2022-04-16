package br.com.ezfix.api.controller.response;

import br.com.ezfix.api.model.EnderecoEspecifico;

import java.util.List;

public class PerfilSolicitante {

    private String cpf;
    private String email;
    private String nome;
    private String telefonePrimario;
    private String telefoneSecundario;
    private List<EnderecoEspecifico> enderecoEspecificos;

    public PerfilSolicitante(String cpf, String email, String nome, String telefonePrimario, String telefoneSecundario) {
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.telefonePrimario = telefonePrimario;
        this.telefoneSecundario = telefoneSecundario;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefonePrimario() {
        return telefonePrimario;
    }

    public String getTelefoneSecundario() {
        return telefoneSecundario;
    }

    public List<EnderecoEspecifico> getEnderecoEspecificos() {
        return enderecoEspecificos;
    }

    public void setEnderecoEspecificos(List<EnderecoEspecifico> enderecoEspecificos) {
        this.enderecoEspecificos = enderecoEspecificos;
    }
}
