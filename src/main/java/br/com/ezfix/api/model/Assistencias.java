package br.com.ezfix.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Assistencias {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeFantasia;
    @NotNull
    private Long telefonePrimario;
    private Long telefoneSecundario;
    @OneToOne
    private Representantes representante;

    @ManyToMany
    private List<Enderecos> enderecos;

    @ManyToMany
    private List<Servicos> servicos;

    @ManyToOne
    private Planos plano;

    public Assistencias() {
    }

    public Assistencias(String nomeFantasia, Long telefonePrimario, Long telefoneSecundario, Representantes representante, List<Enderecos> enderecos,  Planos plano) {
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

    public Representantes getRepresentante() {
        return representante;
    }

    public List<Enderecos> getEnderecos() {
        return enderecos;
    }

    public List<Servicos> getTipoServicos() {
        return servicos;
    }

    public Planos getPlano() {
        return plano;
    }
}
