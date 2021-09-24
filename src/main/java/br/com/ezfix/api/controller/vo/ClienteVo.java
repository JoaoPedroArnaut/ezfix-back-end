package br.com.ezfix.api.controller.vo;

import br.com.ezfix.api.model.Solicitante;
import br.com.ezfix.api.model.Usuario;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public class ClienteVo {

    private Long cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String sexo;
    private Long telefonePrimario;
    private Long telefoneSecundario;
    private Long cep;
    private Long numero;
    private String complemento;
    private Usuario usuario;
    private Page<Solicitante> clientes;

    public ClienteVo(Solicitante solicitante) {
        this.cpf = solicitante.getCpf();
        this.nome = solicitante.getNome();
        this.dataNascimento = solicitante.getDataNascimento();
        this.sexo = solicitante.getSexo();
        this.telefonePrimario = solicitante.getTelefonePrimario();
        this.telefoneSecundario = solicitante.getTelefoneSecundario();
        this.usuario = solicitante.getUsuario();
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Long getTelefonePrimario() {
        return telefonePrimario;
    }

    public void setTelefonePrimario(Long telefonePrimario) {
        this.telefonePrimario = telefonePrimario;
    }

    public Long getTelefoneSecundario() {
        return telefoneSecundario;
    }

    public void setTelefoneSecundario(Long telefoneSecundario) {
        this.telefoneSecundario = telefoneSecundario;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public static Page<ClienteVo> converter(Page<Solicitante> clientes) {
        return clientes.map(ClienteVo::new);
    }
}
