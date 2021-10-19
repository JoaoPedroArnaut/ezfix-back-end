package br.com.ezfix.api.controller.form;

import br.com.ezfix.api.model.Assistencia;
import br.com.ezfix.api.model.Certificacao;

import java.time.LocalDate;

public class CertificacoesForm {

    private String nomeCurso;
    private Long quantidadeHoras; //confirmar qual seria o melhor tipo para essa coluna;
    private LocalDate dataInicio;
    private LocalDate dataConclusao;
    private String anexo;
    private Certificacao certificacao;


    public CertificacoesForm(String nomeCurso, Long quantidadeHoras, LocalDate dataInicio, LocalDate dataConclusao, String anexo) {
        this.nomeCurso = nomeCurso;
        this.quantidadeHoras = quantidadeHoras;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
        this.anexo = anexo;
    }

    public Certificacao getCertificacoes() {
        return certificacao;
    }

    public void converterCertificacoes(Assistencia assistencia){
        this.certificacao = new Certificacao(
                this.nomeCurso,
                this.quantidadeHoras,
                this.dataInicio,
                this.dataConclusao,
                this.anexo,
                assistencia
        );
    }
}
