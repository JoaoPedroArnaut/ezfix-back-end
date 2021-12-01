package br.com.ezfix.api.controller.response;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CertificadoSemAssistencia {

    private String nomeCurso;
    private Long quantidadeHoras; //confirmar qual seria o melhor tipo para essa coluna;
    private LocalDate dataInicio;
    private LocalDate dataConclusao;

    public CertificadoSemAssistencia(String nomeCurso, Long quantidadeHoras, LocalDate dataInicio, LocalDate dataConclusao) {
        this.nomeCurso = nomeCurso;
        this.quantidadeHoras = quantidadeHoras;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public Long getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public String getDataInicio() {
        return dataInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getDataConclusao() {
        return dataConclusao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
