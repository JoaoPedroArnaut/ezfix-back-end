package br.com.ezfix.api.controller.request;

public class AtualizarStatusPedido {

    private String status;

    public AtualizarStatusPedido(String status) {
        this.status = status;
    }

    public AtualizarStatusPedido() {
    }

    public String getStatus() {
        return status;
    }
}
