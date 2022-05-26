package br.com.ezfix.api.controller.response;

import br.com.ezfix.api.model.Marca;
import br.com.ezfix.api.model.Modelo;
import br.com.ezfix.api.model.Tipo;

import javax.persistence.ManyToOne;

public class ItemOrcamentoOnlyNames {

    private String descricao;
    private String marca;
    private String tipo;
    private String modelo;

    public ItemOrcamentoOnlyNames(String descricao, String marca, String tipo, String modelo) {
        this.descricao = descricao;
        this.marca = marca;
        this.tipo = tipo;
        this.modelo = modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public String getModelo() {
        return modelo;
    }
}
