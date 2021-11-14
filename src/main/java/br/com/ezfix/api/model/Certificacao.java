package br.com.ezfix.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonIgnore
    @Column(length = 20_000_000)
    private byte[] anexo;

    @ManyToOne
    private Assistencia assistencia;

    public Certificacao() {
    }

    public Certificacao(String nomeCurso, Long quantidadeHoras, LocalDate dataInicio, LocalDate dataConclusao, Assistencia assistencia) {
        this.nomeCurso = nomeCurso;
        this.quantidadeHoras = quantidadeHoras;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
        this.assistencia = assistencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Long getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public void setQuantidadeHoras(Long quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public byte[] getAnexo() {
        return anexo;
    }

    public void setAnexo(byte[] anexo) {
        this.anexo = anexo;
    }

    public Assistencia getAssistencia() {
        return assistencia;
    }

    public void setAssistencia(Assistencia assistencia) {
        this.assistencia = assistencia;
    }
}
