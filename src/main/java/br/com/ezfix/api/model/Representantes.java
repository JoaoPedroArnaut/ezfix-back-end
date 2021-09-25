package br.com.ezfix.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Representantes {

    @Id
    private String documento;
    @NotNull
    private String nome;
    @NotNull
    private LocalDate dataNascimento;

    @OneToOne
    private Usuarios usuario;

    public Representantes() {
    }

    public Representantes(String documento, String nome, LocalDate dataNascimento, Usuarios usuario) {
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

    public Usuarios getUsuario() {
        return usuario;
    }
}
