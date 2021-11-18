package br.com.ezfix.api.controller.form;

import br.com.ezfix.api.model.ItemOrcamento;
import br.com.ezfix.api.model.Produto;

public class ItemForm {

    private String problema;
    private String descricao;
    private String marca;
    private String modelo;

    public ItemForm(String problema, String descricao, String marca, String modelo) {
        this.problema = problema;
        this.descricao = descricao;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public ItemOrcamento converterItem(Produto produto){
        return new ItemOrcamento(
                this.problema,
                this.descricao,
                produto
        );
    }
}
