package br.com.ezfix.api.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
public class Orcamento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valorTotal = 0.;
    private String statusGeral = "aguardando resposta tecnico";
    private LocalDate dataCriacao = LocalDate.now();
    private LocalDateTime dataSolicitacao = LocalDateTime.now();
    private LocalDate dataPrivista;

    @ManyToOne
    private Solicitante solicitante;

    @ManyToOne
    private Assistencia assistencia;

    public Orcamento() {
    }

    public Orcamento(String solicitante, Long assistencia) {
        this.solicitante = new Solicitante(solicitante);
        this.assistencia = new Assistencia(assistencia);
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

    public String getDataSolicitacao() {
        return this.dataSolicitacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public LocalDate getDataPrivista() {
        return dataPrivista;
    }

    public void setDataPrivista(LocalDate dataPrivista) {
        this.dataPrivista = dataPrivista;
    }
}
