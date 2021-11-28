package br.com.ezfix.api.model;

import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Comentario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataComentario;
    private String comentario;
    private Double avaliacao;

    @OneToOne
    private Assistencia assistencia;

    @OneToOne
    private Solicitante solicitante;

    @OneToOne
    private Orcamento orcamento;


    public Comentario(LocalDateTime dataComentario, String comentario, Double avaliacao, Assistencia assistencia, Solicitante solicitante, Orcamento orcamento) {
        this.dataComentario = dataComentario;
        this.comentario = comentario;
        this.avaliacao = avaliacao;
        this.assistencia = assistencia;
        this.solicitante = solicitante;
        this.orcamento = orcamento;
    }

    public Comentario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataComentario() {
        return dataComentario;
    }

    public void setDataComentario(LocalDateTime dataComentario) {
        this.dataComentario = dataComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Assistencia getAssistencia() {
        return assistencia;
    }

    public void setAssistencia(Assistencia assistencia) {
        this.assistencia = assistencia;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }
}
