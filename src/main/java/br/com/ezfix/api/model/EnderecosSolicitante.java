package br.com.ezfix.api.model;

import javax.persistence.*;

@Entity
public class EnderecosSolicitante {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Solicitante solicitante;
    @ManyToOne
    private EnderecoEspecifico enderecoEspecifico;

    public EnderecosSolicitante(Solicitante solicitante, EnderecoEspecifico enderecoEspecifico) {
        this.solicitante = solicitante;
        this.enderecoEspecifico = enderecoEspecifico;
    }

    public EnderecosSolicitante() {

    }

    public Long getId() {
        return id;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public EnderecoEspecifico getEnderecoEspecifico() {
        return enderecoEspecifico;
    }
}
