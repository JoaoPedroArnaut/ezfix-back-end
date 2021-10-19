package br.com.ezfix.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Assistencia {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeFantasia;
    @NotNull
    private Long telefonePrimario;
    private Long telefoneSecundario;
    @OneToOne
    private Representante representante;

    @ManyToMany
    private List<Endereco> enderecos;

    @ManyToMany
    private List<Servico> servicos;

    @OneToOne
    private Plano plano;

    public Assistencia() {
    }

    public Assistencia(String nomeFantasia, Long telefonePrimario, Long telefoneSecundario, Representante representante, List<Endereco> enderecos, Plano plano) {
        this.nomeFantasia = nomeFantasia;
        this.telefonePrimario = telefonePrimario;
        this.telefoneSecundario = telefoneSecundario;
        this.representante = representante;
        this.enderecos = enderecos;
        this.plano = plano;
    }

    public Long getId() {
        return id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public Long getTelefonePrimario() {
        return telefonePrimario;
    }

    public Long getTelefoneSecundario() {
        return telefoneSecundario;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public List<Servico> getTipoServicos() {
        return servicos;
    }

    public Plano getPlano() {
        return plano;
    }
}
