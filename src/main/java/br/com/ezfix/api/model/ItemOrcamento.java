package br.com.ezfix.api.model;

import javax.persistence.*;

@Entity
public class ItemOrcamento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valorServico;
    private String problema;
    private String descricao;
    private String status;

    @ManyToOne
    private Produto produto;

    public ItemOrcamento() {
    }

    public ItemOrcamento(Double valorServico, String problema, String descricao, String status, Produto produto) {
        this.valorServico = valorServico;
        this.problema = problema;
        this.descricao = descricao;
        this.status = status;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorServico() {
        return valorServico;
    }

    public void setValorServico(Double valorServico) {
        this.valorServico = valorServico;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
