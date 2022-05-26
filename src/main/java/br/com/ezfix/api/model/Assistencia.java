package br.com.ezfix.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Assistencia {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeFantasia;
    private Double avaliacao = 5.;
    @NotNull
    private String telefonePrimario;
    private String telefoneSecundario;

    @JsonIgnore
    @Column(length = 20_000_000)
    private byte[] perfil;

    @OneToOne
    private Representante representante;

    @ManyToMany
    private List<Servico> servicos;

    @OneToOne
    private Plano plano;

    public Assistencia() {
    }

    public Assistencia(Long id) {
        this.id = id;
    }

    public Assistencia(String nomeFantasia, String telefonePrimario, String telefoneSecundario, Representante representante, Plano plano) {
        this.nomeFantasia = nomeFantasia;
        this.telefonePrimario = telefonePrimario;
        this.telefoneSecundario = telefoneSecundario;
        this.representante = representante;
        this.plano = plano;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
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

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }
}
