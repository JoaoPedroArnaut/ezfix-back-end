package br.com.ezfix.api.controller.vo;

public class TokenVo {

    private String token;
    private String tipo;

    public TokenVo(String token, String tipo) {
        this.token = token;
        this.tipo = tipo;
    }

    public String getToken() {
        return token;
    }

    public String getTipo() {
        return tipo;
    }
}
