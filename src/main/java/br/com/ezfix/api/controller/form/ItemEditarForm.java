package br.com.ezfix.api.controller.form;

public class ItemEditarForm {

    private Long i;
    private Double v;

    public ItemEditarForm(Long i, Double v) {
        this.i = i;
        this.v = v;
    }

    public Long getI() {
        return i;
    }

    public void setI(Long i) {
        this.i = i;
    }

    public Double getV() {
        return v;
    }

    public void setV(Double v) {
        this.v = v;
    }
}
