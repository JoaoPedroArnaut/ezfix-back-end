package br.com.ezfix.api.model;

import javax.persistence.*;

@Entity
public class TipoServicos {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String servico;

    @ManyToOne
    private Assistencias assistencia;

    public TipoServicos() {
    }

    public TipoServicos(Long id, String servico, Assistencias assistencia) {
        this.id = id;
        this.servico = servico;
        this.assistencia = assistencia;
    }

    public Long getId() {
        return id;
    }

    public String getServico() {
        return servico;
    }

    public Assistencias getAssistencia() {
        return assistencia;
    }
}
