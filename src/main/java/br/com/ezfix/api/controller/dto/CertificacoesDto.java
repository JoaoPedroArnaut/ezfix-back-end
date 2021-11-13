package br.com.ezfix.api.controller.dto;

import br.com.ezfix.api.model.Assistencia;
import br.com.ezfix.api.model.Certificacao;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public class CertificacoesDto {

    private Long id;
    private String nomeCurso;
    private Long quantidadeHoras; //confirmar qual seria o melhor tipo para essa coluna;
    private LocalDate dataInicio;
    private LocalDate dataConclusao;
    private String anexo;
    private Assistencia assistencia;

    public CertificacoesDto(Certificacao certificacao) {
        this.id = certificacao.getId();
        this.nomeCurso = certificacao.getNomeCurso();
        this.quantidadeHoras = certificacao.getQuantidadeHoras();
        this.dataInicio = certificacao.getDataInicio();
        this.dataConclusao = certificacao.getDataConclusao();
        this.assistencia = certificacao.getAssistencia();
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

    public static Page<CertificacoesDto> converter(Page<Certificacao> certificacoes) {
        return certificacoes.map(CertificacoesDto::new);
    }
}
