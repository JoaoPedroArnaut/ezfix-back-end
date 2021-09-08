package br.com.ezfix.api.controller.vo;

import br.com.ezfix.api.model.Cliente;
import br.com.ezfix.api.model.Usuario;
import br.com.ezfix.api.util.Convertivel;
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
    private Page<Cliente> clientes;

    public ClienteVo(Cliente cliente) {
        this.cpf = cliente.getCpf();
        this.nome = cliente.getNome();
        this.dataNascimento = cliente.getDataNascimento();
        this.sexo = cliente.getSexo();
        this.telefonePrimario = cliente.getTelefonePrimario();
        this.telefoneSecundario = cliente.getTelefoneSecundario();
        this.cep = cliente.getCep();
        this.numero = cliente.getNumero();
        this.complemento = cliente.getComplemento();
        this.usuario = cliente.getUsuario();
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

    public static Page<ClienteVo> converter(Page<Cliente> clientes) {
        return clientes.map(ClienteVo::new);
    }
}
