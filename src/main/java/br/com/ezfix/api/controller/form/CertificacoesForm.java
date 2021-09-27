package br.com.ezfix.api.controller.form;

import br.com.ezfix.api.model.Assistencias;
import br.com.ezfix.api.model.Certificacoes;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CertificacoesForm {

    private String nomeCurso;
    private Long quantidadeHoras; //confirmar qual seria o melhor tipo para essa coluna;
    private LocalDate dataInicio;
    private LocalDate dataConclusao;
    private String anexo;
    private Certificacoes certificacoes;


    public CertificacoesForm(String nomeCurso, Long quantidadeHoras, LocalDate dataInicio, LocalDate dataConclusao, String anexo) {
        this.nomeCurso = nomeCurso;
        this.quantidadeHoras = quantidadeHoras;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
        this.anexo = anexo;
    }

    public Certificacoes getCertificacoes() {
        return certificacoes;
    }

    public void converterCertificacoes(Assistencias assistencia){
        this.certificacoes = new Certificacoes(
                this.nomeCurso,
                this.quantidadeHoras,
                this.dataInicio,
                this.dataConclusao,
                this.anexo,
                assistencia
        );
    }
}
