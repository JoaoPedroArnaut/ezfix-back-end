package br.com.ezfix.api.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Orcamento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valorTotal = 0.;
    private String statusGeral = "agurdando resposta tecnico";

    @ManyToOne
    private Solicitante solicitante;

    @ManyToOne
    private Assistencia assistencia;

    @OneToMany
    private List<ItemOrcamento> itens;

    public Orcamento() {
    }

    public Orcamento(Solicitante solicitante, Assistencia assistencia, List<ItemOrcamento> itens) {
        this.valorTotal = valorTotal;
        this.statusGeral = statusGeral;
        this.solicitante = solicitante;
        this.assistencia = assistencia;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatusGeral() {
        return statusGeral;
    }

    public void setStatusGeral(String statusGeral) {
        this.statusGeral = statusGeral;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public Assistencia getAssistencia() {
        return assistencia;
    }

    public void setAssistencia(Assistencia assistencia) {
        this.assistencia = assistencia;
    }

    public List<ItemOrcamento> getItens() {
        return itens;
    }

    public void setItens(List<ItemOrcamento> itens) {
        this.itens = itens;
    }
}
