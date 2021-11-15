package br.com.ezfix.api.model;

import javax.persistence.*;

@Entity
public class EnderecoEspecifico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long numero;
    private String complemento;
    @ManyToOne
    private EnderecoGeral enderecoGeral;

    public EnderecoEspecifico() {
    }

    public EnderecoEspecifico(Long numero, String complemento, EnderecoGeral enderecoGeral) {
        this.numero = numero;
        this.complemento = complemento;
        this.enderecoGeral = enderecoGeral;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public EnderecoGeral getEnderecoGeral() {
        return enderecoGeral;
    }

    public void setEnderecoGeral(EnderecoGeral enderecoGeral) {
        this.enderecoGeral = enderecoGeral;
    }
}
