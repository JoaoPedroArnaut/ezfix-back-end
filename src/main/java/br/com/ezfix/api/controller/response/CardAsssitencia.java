package br.com.ezfix.api.controller.response;

public class CardAsssitencia {

    private Long id;
    private String nomeFantasia;
    private Double avaliacao;
    private String cidade;
    private String estado;

    public CardAsssitencia(Long id, String nomeFantasia, Double avaliacao, String cidade, String estado) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.avaliacao = avaliacao;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Long getId() {
        return id;
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
}
