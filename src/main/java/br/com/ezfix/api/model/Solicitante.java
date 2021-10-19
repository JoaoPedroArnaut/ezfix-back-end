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
    private Long telefonePrimario;
    private Long telefoneSecundario;
    @OneToOne
    private Usuario usuario;

    @ManyToMany
    private List<Endereco> enderecos;

    public Solicitante() {

    }

    public Solicitante(String cpf, String nome, LocalDate dataNascimento, Long telefonePrimario, Long telefoneSecundario, Usuario usuario, List<Endereco> enderecos) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefonePrimario = telefonePrimario;
        this.telefoneSecundario = telefoneSecundario;
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

    public Long getTelefonePrimario() {
        return telefonePrimario;
    }

    public Long getTelefoneSecundario() {
        return telefoneSecundario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }
}
