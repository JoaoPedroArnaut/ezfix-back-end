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
    private String telefonePrimario;
    private String telefoneSecundario;
    @NotNull
    private Long numero;
    private String complemento;
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

    public Assistencia(String nomeFantasia, String telefonePrimario, String telefoneSecundario, Long numero, String complemento, Representante representante, List<Endereco> enderecos, Plano plano) {
        this.nomeFantasia = nomeFantasia;
        this.telefonePrimario = telefonePrimario;
        this.telefoneSecundario = telefoneSecundario;
        this.numero = numero;
        this.complemento = complemento;
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

    public String getTelefonePrimario() {
        return telefonePrimario;
    }

    public String getTelefoneSecundario() {
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
