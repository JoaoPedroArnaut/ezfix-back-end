package br.com.ezfix.api.controller.vo;

import br.com.ezfix.api.model.Enderecos;
import br.com.ezfix.api.model.Solicitantes;
import br.com.ezfix.api.model.Usuarios;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public class SolicitanteVo {

    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private Long telefonePrimario;
    private Long telefoneSecundario;
    private Usuarios usuarios;
    private List<Enderecos> enderecos;

    public SolicitanteVo(Solicitantes solicitantes) {
        this.cpf = solicitantes.getCpf();
        this.nome = solicitantes.getNome();
        this.dataNascimento = solicitantes.getDataNascimento();
        this.telefonePrimario = solicitantes.getTelefonePrimario();
        this.telefoneSecundario = solicitantes.getTelefoneSecundario();
        this.usuarios = solicitantes.getUsuario();
        this.enderecos = solicitantes.getEnderecos();
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

    public Usuarios getUsuario() {
        return usuarios;
    }

    public void setUsuario(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public List<Enderecos> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Enderecos> enderecos) {
        this.enderecos = enderecos;
    }

    public static Page<SolicitanteVo> converter(Page<Solicitantes> solicitantes) {
        return solicitantes.map(SolicitanteVo::new);
    }
}
