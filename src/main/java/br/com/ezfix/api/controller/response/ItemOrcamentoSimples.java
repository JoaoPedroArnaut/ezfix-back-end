package br.com.ezfix.api.controller.response;

public class ItemOrcamentoSimples {

    private String marca;
    private String modelo;

    public ItemOrcamentoSimples(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
}
