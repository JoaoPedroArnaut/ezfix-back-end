package br.com.ezfix.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Representante {

    @Id
    private String documento;
    @NotNull
    private String nome;
    @NotNull
    private LocalDate dataNascimento;

    @OneToOne
    private Usuario usuario;

    public Representante() {
    }

    public Representante(String documento, String nome, LocalDate dataNascimento, Usuario usuario) {
        this.documento = documento;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.usuario = usuario;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
