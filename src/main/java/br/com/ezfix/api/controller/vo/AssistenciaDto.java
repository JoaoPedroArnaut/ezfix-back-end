package br.com.ezfix.api.controller.vo;

import br.com.ezfix.api.model.*;
import org.springframework.data.domain.Page;

import java.util.List;

public class AssistenciaDto {

    private Long id;
    private String nomeFantasia;
    private Long telefonePrimario;
    private Long telefoneSecundario;
    private Representantes representante;
    private List<Enderecos> enderecos;
    private List<Servicos> servicos;
    private Planos plano;

    public AssistenciaDto(Assistencias assistencia) {
        this.id = assistencia.getId();
        this.nomeFantasia = assistencia.getNomeFantasia();
        this.telefonePrimario = assistencia.getTelefonePrimario();
        this.telefoneSecundario = assistencia.getTelefoneSecundario();
        this.representante = assistencia.getRepresentante();
        this.enderecos = assistencia.getEnderecos();
        this.servicos = assistencia.getTipoServicos();
        this.plano = assistencia.getPlano();
    }

    public Long getId() {
        return id;
    }

    public Long getTelefonePrimario() {
        return telefonePrimario;
    }

    public Long getTelefoneSecundario() {
        return telefoneSecundario;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public Representantes getRepresentante() {
        return representante;
    }

    public List<Enderecos> getEnderecos() {
        return enderecos;
    }

    public List<Servicos> getTipoServicos() {
        return servicos;
    }

    public Planos getPlano() {
        return plano;
    }

    public static Page<AssistenciaDto> converter(Page<Assistencias> assistencias) {
        return assistencias.map(AssistenciaDto::new);
    }
}
