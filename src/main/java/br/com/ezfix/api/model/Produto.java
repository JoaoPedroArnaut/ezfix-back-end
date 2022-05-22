package br.com.ezfix.api.model;

import javax.persistence.*;

@Entity
public class Produto {

    @Id
    private Long id;

    @ManyToOne
    private Marca marca;

    @ManyToOne
    private Tipo tipo;

    @ManyToOne
    private Modelo modelo;

    public Produto(Long id, Tipo tipo, Modelo modelo) {
        this.id = id;
        this.tipo = tipo;
        this.modelo = modelo;
    }

    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
