package br.com.ezfix.api.controller.response;

import br.com.ezfix.api.model.ItemOrcamento;

import java.time.LocalDateTime;
import java.util.List;

public class OrcamenteTecnico {

    private Long idOrcamento;
    private String nomeSolicitante;
    private String status;
    private LocalDateTime dataSolicitacao;
    private List<ItemOrcamentoOnlyNames> itemOrcamentoList;

    public OrcamenteTecnico(Long idOrcamento, String nomeSolicitante, String status, LocalDateTime dataSolicitacao) {
        this.idOrcamento = idOrcamento;
        this.nomeSolicitante = nomeSolicitante;
        this.status = status;
        this.dataSolicitacao = dataSolicitacao;
    }

    public Long getIdOrcamento() {
        return idOrcamento;
    }

    public String getNomeSolicitante() {
        return nomeSolicitante;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public List<ItemOrcamentoOnlyNames> getItemOrcamentoList() {
        return itemOrcamentoList;
    }

    public void setItemOrcamentoList(List<ItemOrcamentoOnlyNames> itemOrcamentoList) {
        this.itemOrcamentoList = itemOrcamentoList;
    }
}
