package br.com.ezfix.api.model;

import javax.persistence.*;

@Entity
public class EnderecoAssistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Assistencia assistencia;
    @ManyToOne
    private EnderecoEspecifico enderecoEspecifico;

    public EnderecoAssistencia(Assistencia assistencia, EnderecoEspecifico enderecoEspecifico) {
        this.assistencia = assistencia;
        this.enderecoEspecifico = enderecoEspecifico;
    }

    public EnderecoAssistencia() {

    }

    public Long getId() {
        return id;
    }

    public Assistencia getAssistencia() {
        return assistencia;
    }

    public EnderecoEspecifico getEnderecoEspecifico() {
        return enderecoEspecifico;
    }
}
