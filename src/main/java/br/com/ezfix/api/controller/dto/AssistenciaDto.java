package br.com.ezfix.api.controller.dto;

import br.com.ezfix.api.model.*;
import org.springframework.data.domain.Page;

import java.util.List;

public class AssistenciaDto {

    private Long id;
    private String nomeFantasia;
    private String telefonePrimario;
    private String telefoneSecundario;
    private Representante representante;
    private List<EnderecoGeral> enderecoGerals;
    private List<Servico> servicos;
    private Plano plano;

    public AssistenciaDto(Assistencia assistencia) {
        this.id = assistencia.getId();
        this.nomeFantasia = assistencia.getNomeFantasia();
        this.telefonePrimario = assistencia.getTelefonePrimario();
        this.telefoneSecundario = assistencia.getTelefoneSecundario();
        this.representante = assistencia.getRepresentante();
        this.enderecoGerals = assistencia.getEnderecos();
        this.servicos = assistencia.getServicos();
        this.plano = assistencia.getPlano();
    }

    public Long getId() {
        return id;
    }

    public String getTelefonePrimario() {
        return telefonePrimario;
    }

    public String getTelefoneSecundario() {
        return telefoneSecundario;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public List<EnderecoGeral> getEnderecos() {
        return enderecoGerals;
    }

    public List<Servico> getTipoServicos() {
        return servicos;
    }

    public Plano getPlano() {
        return plano;
    }

    public static Page<AssistenciaDto> converter(Page<Assistencia> assistencias) {
        return assistencias.map(AssistenciaDto::new);
    }
}
