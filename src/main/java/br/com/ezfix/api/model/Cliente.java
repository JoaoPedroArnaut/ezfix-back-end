package br.com.ezfix.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Cliente {

    @Id
    private Long cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String sexo;
    private Long telefonePrimario;
    private Long telefoneSecundario;
    private Long cep;
    private Long numero;
    private String complemento;
    @ManyToOne
    private Usuario usuario;

    public Cliente(Long cpf, String nome, LocalDate dataNascimento, String sexo, Long telefonePrimario, Long telefoneSecundario, Long cep, Long numero, String complemento) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.telefonePrimario = telefonePrimario;
        this.telefoneSecundario = telefoneSecundario;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }

    public Cliente() {

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

    public Usuario getUsuario() {
        return usuario;
    }
}
