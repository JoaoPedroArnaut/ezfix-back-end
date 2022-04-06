package br.com.ezfix.api.controller.response;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CertificadoSemAnexo {

    private Long id;
    private String nomeCurso;
    private Long quantidadeHoras; //confirmar qual seria o melhor tipo para essa coluna;
    private LocalDate dataInicio;
    private LocalDate dataConclusao;

    public CertificadoSemAnexo(Long id, String nomeCurso, Long quantidadeHoras, LocalDate dataInicio, LocalDate dataConclusao) {
        this.id = id;
        this.nomeCurso = nomeCurso;
        this.quantidadeHoras = quantidadeHoras;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
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
}
