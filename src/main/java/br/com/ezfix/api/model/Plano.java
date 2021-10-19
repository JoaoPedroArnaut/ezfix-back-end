package br.com.ezfix.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plano {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;

    public Plano() {
    }

    public Plano(String tipo) {
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }
}
