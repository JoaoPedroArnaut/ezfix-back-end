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
    @NotNull
    private Long numero;
    private String complemento;

    @JsonIgnore
    @Column(length = 20_000_000)
    private byte[] perfil;

    @OneToOne
    private Representante representante;

    @OneToMany
    private List<EnderecoEspecifico> enderecoEspecificos;

    @ManyToMany
    private List<Servico> servicos;

    @OneToOne
    private Plano plano;

    public Assistencia() {
    }

    public Assistencia(String nomeFantasia, String telefonePrimario, String telefoneSecundario, Long numero, String complemento, Representante representante, List<EnderecoEspecifico> enderecoEspecificos, Plano plano) {
        this.nomeFantasia = nomeFantasia;
        this.telefonePrimario = telefonePrimario;
        this.telefoneSecundario = telefoneSecundario;
        this.numero = numero;
        this.complemento = complemento;
        this.representante = representante;
        this.enderecoEspecificos = enderecoEspecificos;
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

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

    public List<EnderecoEspecifico> getEnderecoEspecificos() {
        return enderecoEspecificos;
    }

    public void setEnderecoEspecificos(List<EnderecoEspecifico> enderecoEspecificos) {
        this.enderecoEspecificos = enderecoEspecificos;
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
