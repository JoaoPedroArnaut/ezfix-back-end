package br.com.ezfix.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonIgnore
    @Column(length = 20_000_000)
    private byte[] perfil;

    @OneToMany
    private List<EnderecoEspecifico> enderecoEspecificos;

    @OneToOne
    private Usuario usuario;

    public Solicitante() {

    }

    public Solicitante(String cpf, String nome, LocalDate dataNascimento, String telefonePrimario, String telefoneSecundario, List<EnderecoEspecifico> enderecoEspecificos, Usuario usuario) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefonePrimario = telefonePrimario;
        this.telefoneSecundario = telefoneSecundario;
        this.enderecoEspecificos = enderecoEspecificos;
        this.usuario = usuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefonePrimario() {
        return telefonePrimario;
    }

    public void setTelefonePrimario(String telefonePrimario) {
        this.telefonePrimario = telefonePrimario;
    }

    public String getTelefoneSecundario() {
        return telefoneSecundario;
    }

    public void setTelefoneSecundario(String telefoneSecundario) {
        this.telefoneSecundario = telefoneSecundario;
    }

    public byte[] getPerfil() {
        return perfil;
    }

    public void setPerfil(byte[] perfil) {
        this.perfil = perfil;
    }

    public List<EnderecoEspecifico> getEnderecoEspecificos() {
        return enderecoEspecificos;
    }

    public void setEnderecoEspecificos(List<EnderecoEspecifico> enderecoEspecificos) {
        this.enderecoEspecificos = enderecoEspecificos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
