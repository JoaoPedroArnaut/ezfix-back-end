package br.com.ezfix.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Solicitantes {

    @Id
    private Long cpf;
    @NotNull
    private String nome;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private Long telefonePrimario;
    private Long telefoneSecundario;
    @OneToOne
    private Usuarios usuarios;

    @ManyToMany
    private List<Enderecos> enderecos;

    public Solicitantes() {

    }

    public Solicitantes(Long cpf, String nome, LocalDate dataNascimento, Long telefonePrimario, Long telefoneSecundario, Usuarios usuarios, List<Enderecos> enderecos) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefonePrimario = telefonePrimario;
        this.telefoneSecundario = telefoneSecundario;
        this.usuarios = usuarios;
        this.enderecos = enderecos;
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

    public Long getTelefonePrimario() {
        return telefonePrimario;
    }

    public Long getTelefoneSecundario() {
        return telefoneSecundario;
    }

    public Usuarios getUsuario() {
        return usuarios;
    }

    public List<Enderecos> getEnderecos() {
        return enderecos;
    }
}
