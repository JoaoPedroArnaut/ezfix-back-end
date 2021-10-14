package br.com.ezfix.api.controller.vo;

import br.com.ezfix.api.model.Assistencias;
import br.com.ezfix.api.model.Certificacoes;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public class CertificacoesDto {

    private Long id;
    private String nomeCurso;
    private Long quantidadeHoras; //confirmar qual seria o melhor tipo para essa coluna;
    private LocalDate dataInicio;
    private LocalDate dataConclusao;
    private String anexo;
    private Assistencias assistencia;

    public CertificacoesDto(Certificacoes certificacoes) {
        this.id = certificacoes.getId();
        this.nomeCurso = certificacoes.getNomeCurso();
        this.quantidadeHoras = certificacoes.getQuantidadeHoras();
        this.dataInicio = certificacoes.getDataInicio();
        this.dataConclusao = certificacoes.getDataConclusao();
        this.anexo = certificacoes.getAnexo();
        this.assistencia = certificacoes.getAssistencia();
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

    public Assistencias getAssistencia() {
        return assistencia;
    }

    public static Page<CertificacoesDto> converter(Page<Certificacoes> certificacoes) {
        return certificacoes.map(CertificacoesDto::new);
    }
}
