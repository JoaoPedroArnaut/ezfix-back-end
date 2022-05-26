package br.com.ezfix.api.controller.response;

public class CidadeEstado {

    private String cidade;
    private String estado;

    public CidadeEstado(String cidade, String estado) {
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }
}
