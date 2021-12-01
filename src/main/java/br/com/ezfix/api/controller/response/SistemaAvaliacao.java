package br.com.ezfix.api.controller.response;

public class SistemaAvaliacao {

    private Double avaliacao;

    public SistemaAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }
}
