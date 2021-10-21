package br.com.ezfix.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Certificacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nomeCurso;
    @NotNull
    private Long quantidadeHoras; //confirmar qual seria o melhor tipo para essa coluna;
    @NotNull
    private LocalDate dataInicio;
    private LocalDate dataConclusao;
    private String anexo;

    @ManyToOne
    private Assistencia assistencia;

    public Certificacao() {
    }

    public Certificacao(String nomeCurso, Long quantidadeHoras, LocalDate dataInicio, LocalDate dataConclusao, String anexo, Assistencia assistencia) {
        this.nomeCurso = nomeCurso;
        this.quantidadeHoras = quantidadeHoras;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
        this.anexo = anexo;
        this.assistencia = assistencia;
    }

    public Long getId() {
        return id;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public Long getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public String getAnexo() {
        return anexo;
    }

    public Assistencia getAssistencia() {
        return assistencia;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public void setQuantidadeHoras(Long quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public void setAssistencia(Assistencia assistencia) {
        this.assistencia = assistencia;
    }
}
