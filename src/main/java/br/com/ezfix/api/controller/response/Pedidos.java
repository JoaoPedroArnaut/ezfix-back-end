package br.com.ezfix.api.controller.response;

import br.com.ezfix.api.model.Produto;

import java.util.List;

public class Pedidos {

    private Long idOrcamento;
    private Long idAssistencia;
    private String nomeAssistencia;
    private String status;
    private List<ItemOrcamentoSimples> itens;

    public Pedidos(Long idOrcamento, Long idAssistencia, String nomeAssistencia, String status) {
        this.idOrcamento = idOrcamento;
        this.idAssistencia = idAssistencia;
        this.nomeAssistencia = nomeAssistencia;
        this.status = status;
    }

    public Long getIdOrcamento() {
        return idOrcamento;
    }

    public Long getIdAssistencia() {
        return idAssistencia;
    }

    public String getNomeAssistencia() {
        return nomeAssistencia;
    }

    public String getStatus() {
        return status;
    }

    public List<ItemOrcamentoSimples> getItens() {
        return itens;
    }

    public void setItens(List<ItemOrcamentoSimples> itens) {
        this.itens = itens;
    }
}
