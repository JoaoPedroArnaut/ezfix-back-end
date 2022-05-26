package br.com.ezfix.api.controller.response;

import br.com.ezfix.api.model.Certificado;

import java.util.List;

public class PerfilAssistencia {

    private String nomeFantasia;
    private Double avaliacao;
    private String cidade;
    private String estado;
    private List<CertificadoSemAnexo> certificados;

    public PerfilAssistencia(String nomeFantasia, Double avaliacao) {
        this.nomeFantasia = nomeFantasia;
        this.avaliacao = avaliacao;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public List<CertificadoSemAnexo> getCertificados() {
        return certificados;
    }

    public void setCertificados(List<CertificadoSemAnexo> certificados) {
        this.certificados = certificados;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
