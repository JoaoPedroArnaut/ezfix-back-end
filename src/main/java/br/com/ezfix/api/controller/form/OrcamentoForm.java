package br.com.ezfix.api.controller.form;

import java.util.List;

public class OrcamentoForm {

    private List<ItemEditarForm> itemEditarForms;
    private String status;

    public OrcamentoForm(List<ItemEditarForm> itemEditarForms, String status) {
        this.itemEditarForms = itemEditarForms;
        this.status = status;
    }

    public List<ItemEditarForm> getItemEditarForms() {
        return itemEditarForms;
    }

    public void setItemEditarForms(List<ItemEditarForm> itemEditarForms) {
        this.itemEditarForms = itemEditarForms;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
