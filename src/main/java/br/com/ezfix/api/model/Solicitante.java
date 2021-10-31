package br.com.ezfix.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Solicitante {

    @Id
    private String cpf;
    @NotNull
    private String nome;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private String telefonePrimario;
    private String telefoneSecundario;
    @NotNull
    private Long numero;
    private String complemento;
    @OneToOne
    private Usuario usuario;

    @ManyToMany
    private List<Endereco> enderecos;

    public Solicitante() {

    }

    public Solicitante(String cpf, String nome, LocalDate dataNascimento, String telefonePrimario, String telefoneSecundario, Long numero, String complemento, Usuario usuario, List<Endereco> enderecos) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefonePrimario = telefonePrimario;
        this.telefoneSecundario = telefoneSecundario;
        this.numero = numero;
        this.complemento = complemento;
        this.usuario = usuario;
        this.enderecos = enderecos;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getTelefonePrimario() {
        return telefonePrimario;
    }

    public String getTelefoneSecundario() {
        return telefoneSecundario;
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

    public List<Endereco> getEnderecos() {
        return enderecos;
    }
}
