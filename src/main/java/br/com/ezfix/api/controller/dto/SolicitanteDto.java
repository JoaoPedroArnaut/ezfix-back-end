package br.com.ezfix.api.controller.dto;

import br.com.ezfix.api.model.EnderecoGeral;
import br.com.ezfix.api.model.Solicitante;
import br.com.ezfix.api.model.Usuario;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public class SolicitanteDto {

    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String telefonePrimario;
    private String telefoneSecundario;
    private Usuario usuario;
    private List<EnderecoGeral> enderecoGerals;

    public SolicitanteDto(Solicitante solicitante) {
        this.cpf = solicitante.getCpf();
        this.nome = solicitante.getNome();
        this.dataNascimento = solicitante.getDataNascimento();
        this.telefonePrimario = solicitante.getTelefonePrimario();
        this.telefoneSecundario = solicitante.getTelefoneSecundario();
        this.usuario = solicitante.getUsuario();
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getTelefonePrimario() {
        return telefonePrimario;
    }

    public String getTelefoneSecundario() {
        return telefoneSecundario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<EnderecoGeral> getEnderecos() {
        return enderecoGerals;
    }

    public static Page<SolicitanteDto> converter(Page<Solicitante> solicitantes) {
        return solicitantes.map(SolicitanteDto::new);
    }
}
