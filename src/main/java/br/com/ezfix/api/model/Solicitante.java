package br.com.ezfix.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Solicitante {

    @Id
    private Long cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String sexo;
    private Long telefonePrimario;
    private Long telefoneSecundario;
    @ManyToOne
    private Usuario usuario;

    @ManyToMany
    private List<Endereco> enderecos;

    public Solicitante() {

    }

    public Solicitante(Long cpf, String nome, LocalDate dataNascimento, String sexo, Long telefonePrimario, Long telefoneSecundario, Usuario usuario, List<Endereco> enderecos) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.telefonePrimario = telefonePrimario;
        this.telefoneSecundario = telefoneSecundario;
        this.usuario = usuario;
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

    public String getSexo() {
        return sexo;
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
