package br.com.ezfix.api.model;

import br.com.ezfix.api.model.compositekeys.EnderecoId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Endereco implements Serializable{

    @EmbeddedId
    private EnderecoId enderecoId;
    @NotNull
    private Long numero;
    private String complemento;

    public Endereco() {
    }

    public Endereco(EnderecoId enderecoId, Long numero, String complemento) {
        this.enderecoId = enderecoId;
        this.numero = numero;
        this.complemento = complemento;
    }

    public EnderecoId getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(EnderecoId enderecoId) {
        this.enderecoId = enderecoId;
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
}
