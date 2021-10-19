package br.com.ezfix.api.model;

import javax.persistence.*;

@Entity
public class Servico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String servico;

    public Servico() {
    }

    public Servico(String servico) {
        this.servico = servico;
    }

    public Long getId() {
        return id;
    }

    public String getServico() {
        return servico;
    }
}
