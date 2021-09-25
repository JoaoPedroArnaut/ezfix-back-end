package br.com.ezfix.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Assistencias {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long telefonePrimario;
    private Long telefoneSecundario;
    @OneToOne
    private Representantes representante;

    @ManyToMany
    private List<Enderecos> enderecos;

    public Assistencias() {
    }

    public Assistencias(Long id, Long telefonePrimario, Long telefoneSecundario, Representantes representante, List<Enderecos> enderecos) {
        this.id = id;
        this.telefonePrimario = telefonePrimario;
        this.telefoneSecundario = telefoneSecundario;
        this.representante = representante;
        this.enderecos = enderecos;
    }

    public Long getId() {
        return id;
    }

    public Long getTelefonePrimario() {
        return telefonePrimario;
    }

    public Long getTelefoneSecundario() {
        return telefoneSecundario;
    }

    public Representantes getRepresentante() {
        return representante;
    }

    public List<Enderecos> getEnderecos() {
        return enderecos;
    }
}
