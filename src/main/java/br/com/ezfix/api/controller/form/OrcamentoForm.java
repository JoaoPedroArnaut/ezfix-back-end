package br.com.ezfix.api.controller.form;

import java.util.List;

public class OrcamentoForm {

    private Double valor;

    public OrcamentoForm(Double valor) {
        this.valor = valor;
    }

    public OrcamentoForm() {
    }

    public Double getValor() {
        return valor;
    }
}
