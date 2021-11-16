package br.com.ezfix.api.controller.form;

import br.com.ezfix.api.model.EnderecoEspecifico;
import br.com.ezfix.api.model.EnderecoGeral;

public class EnderecoForm {

    private Long cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private Long numero;
    private String complemento;

    private EnderecoGeral enderecoGeral;
    private EnderecoEspecifico enderecoEspecifico;

    public EnderecoForm(Long cep, String logradouro, String bairro, String cidade, String estado, Long numero, String complemento) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
        this.complemento = complemento;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public EnderecoGeral getEnderecoGeral() {
        return enderecoGeral;
    }

    public void setEnderecoGeral(EnderecoGeral enderecoGeral) {
        this.enderecoGeral = enderecoGeral;
    }

    public EnderecoEspecifico getEnderecoEspecifico() {
        return enderecoEspecifico;
    }

    public void setEnderecoEspecifico(EnderecoEspecifico enderecoEspecifico) {
        this.enderecoEspecifico = enderecoEspecifico;
    }

    public void converteEnderecoGeral(){
        this.enderecoGeral = new EnderecoGeral(this.cep,this.logradouro,this.bairro,this.cidade,this.estado);
    }

    public void converteEnderecoEspecifico(){
        this.enderecoEspecifico = new EnderecoEspecifico(this.numero,this.complemento,this.enderecoGeral);
    }
}
