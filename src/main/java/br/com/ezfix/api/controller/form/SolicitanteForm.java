package br.com.ezfix.api.controller.form;

import java.time.LocalDate;

public class SolicitanteForm {

    private String email;
    private String senha;
    private Long cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String sexo;
    private Long telefonePrimario;
    private Long telefoneSecundario;
    private Long cep;
    private Long numero;
    private String complemento;

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public Long getTelefonePrimario() {
        return telefonePrimario;
    }

    public Long getTelefoneSecundario() {
        return telefoneSecundario;
    }

    public Long getCep() {
        return cep;
    }

    public Long getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }
}
