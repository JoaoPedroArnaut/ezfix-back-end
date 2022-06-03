package br.com.ezfix.api.controller.response;

import br.com.ezfix.api.model.ItemOrcamento;

import java.time.LocalDateTime;
import java.util.List;

public class OrcamenteTecnico {

    private Long idOrcamento;
    private Long idAssistencia;
    private String nomeSolicitante;
    private String nomeAssistencia;
    private String status;
    private LocalDateTime dataSolicitacao;
    private List<ItemOrcamentoOnlyNames> itemOrcamentoList;
    private Double valorTotal;

    public OrcamenteTecnico(Long idOrcamento, Long idAssistencia, String nomeSolicitante, String nomeAssistencia, String status, LocalDateTime dataSolicitacao, Double valorTotal) {
        this.idOrcamento = idOrcamento;
        this.idAssistencia = idAssistencia;
        this.nomeSolicitante = nomeSolicitante;
        this.nomeAssistencia = nomeAssistencia;
        this.status = status;
        this.dataSolicitacao = dataSolicitacao;
        this.valorTotal = valorTotal;
    }

    public Long getIdOrcamento() {
        return idOrcamento;
    }

    public Long getIdAssistencia() {
        return idAssistencia;
    }

    public String getNomeSolicitante() {
        return nomeSolicitante;
    }

    public String getNomeAssistencia() {
        return nomeAssistencia;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public List<ItemOrcamentoOnlyNames> getItemOrcamentoList() {
        return itemOrcamentoList;
    }

    public void setItemOrcamentoList(List<ItemOrcamentoOnlyNames> itemOrcamentoList) {
        this.itemOrcamentoList = itemOrcamentoList;
    }
}
