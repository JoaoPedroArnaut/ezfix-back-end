package br.com.ezfix.api.controller.request;

public class AtualizarStatusPedido {

    private Long id;
    private String status;

    public AtualizarStatusPedido(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
}
