package br.com.ezfix.api.controller.response;

import br.com.ezfix.api.model.Marca;
import br.com.ezfix.api.model.Modelo;
import br.com.ezfix.api.model.Tipo;

import javax.persistence.ManyToOne;

public class ProdutoSimples {

    private Long id;
    private Long marcaId;
    private Long tipoId;
    private Long modeloId;

    public ProdutoSimples(Long id, Long marcaId, Long tipoId, Long modeloId) {
        this.id = id;
        this.marcaId = marcaId;
        this.tipoId = tipoId;
        this.modeloId = modeloId;
    }

    public Long getId() {
        return id;
    }

    public Long getMarcaId() {
        return marcaId;
    }

    public Long getTipoId() {
        return tipoId;
    }

    public Long getModeloId() {
        return modeloId;
    }
}
