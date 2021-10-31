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
    private String telefonePrimario;
    private String telefoneSecundario;
    private Long numero;
    private String complemento;
    private Usuario usuario;
    private List<Endereco> enderecos;

    public SolicitanteDto(Solicitante solicitante) {
        this.cpf = solicitante.getCpf();
        this.nome = solicitante.getNome();
        this.dataNascimento = solicitante.getDataNascimento();
        this.telefonePrimario = solicitante.getTelefonePrimario();
        this.telefoneSecundario = solicitante.getTelefoneSecundario();
        this.numero = solicitante.getNumero();
        this.complemento = solicitante.getComplemento();
        this.usuario = solicitante.getUsuario();
        this.enderecos = solicitante.getEnderecos();
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

    public Long getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public static Page<SolicitanteDto> converter(Page<Solicitante> solicitantes) {
        return solicitantes.map(SolicitanteDto::new);
    }
}
