package br.com.ezfix.api.controller.form;

import br.com.ezfix.api.model.Certificado;

import java.time.LocalDate;

public class CertificacoesForm {

    private String nomeCurso;
    private Long quantidadeHoras; //confirmar qual seria o melhor tipo para essa coluna;
    private LocalDate dataInicio;
    private LocalDate dataConclusao;
    private Certificado certificado;


    public CertificacoesForm(String nomeCurso, Long quantidadeHoras, LocalDate dataInicio, LocalDate dataConclusao) {
        this.nomeCurso = nomeCurso;
        this.quantidadeHoras = quantidadeHoras;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
    }

    public Certificado getCertificacoes() {
        return certificado;
    }

    public void converterCertificacoes(){
        this.certificado = new Certificado(
                this.nomeCurso,
                this.quantidadeHoras,
                this.dataInicio,
                this.dataConclusao
        );
    }
}
