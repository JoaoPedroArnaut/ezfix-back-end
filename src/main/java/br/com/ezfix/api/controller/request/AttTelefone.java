package br.com.ezfix.api.controller.request;

public class AttTelefone {

    private String telefonePrimario;
    private String telefoneSecundario;

    public AttTelefone(String telefonePrimario, String telefoneSecundario) {
        this.telefonePrimario = telefonePrimario;
        this.telefoneSecundario = telefoneSecundario;
    }

    public String getTelefonePrimario() {
        return telefonePrimario;
    }

    public String getTelefoneSecundario() {
        return telefoneSecundario;
    }
}
