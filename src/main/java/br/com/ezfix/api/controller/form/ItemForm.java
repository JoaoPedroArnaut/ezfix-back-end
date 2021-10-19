package br.com.ezfix.api.controller.form;

import br.com.ezfix.api.model.ItemOrcamento;
import br.com.ezfix.api.model.Produto;

public class ItemForm {

    private String problema;
    private String descricao;
    private Long produto;

    public ItemForm(String problema, String descricao, Long produto) {
        this.problema = problema;
        this.descricao = descricao;
        this.produto = produto;
    }

    public Long getProduto() {
        return produto;
    }

    public ItemOrcamento converterItem(Produto produto){
        return new ItemOrcamento(
                0.,
                this.problema,
                this.descricao,
                "agurdando resposta tecnico",
                produto
        );
    }
}
