package br.com.ezfix.api.controller.dto;

import br.com.ezfix.api.model.Endereco;
import br.com.ezfix.api.model.Solicitante;
import br.com.ezfix.api.model.Usuario;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public class SolicitanteDto {

    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private Long telefonePrimario;
    private Long telefoneSecundario;
    private Usuario usuario;
    private List<Endereco> enderecos;

    public SolicitanteDto(Solicitante solicitante) {
        this.cpf = solicitante.getCpf();
        this.nome = solicitante.getNome();
        this.dataNascimento = solicitante.getDataNascimento();
        this.telefonePrimario = solicitante.getTelefonePrimario();
        this.telefoneSecundario = solicitante.getTelefoneSecundario();
        this.usuario = solicitante.getUsuario();
        this.enderecos = solicitante.getEnderecos();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public static Page<SolicitanteDto> converter(Page<Solicitante> solicitantes) {
        return solicitantes.map(SolicitanteDto::new);
    }
}
