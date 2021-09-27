package br.com.ezfix.api.controller.vo;

import br.com.ezfix.api.model.*;
import org.springframework.data.domain.Page;

import java.util.List;

public class AssistenciaVo {

    private Long id;
    private Long telefonePrimario;
    private Long telefoneSecundario;
    private Representantes representante;
    private List<Enderecos> enderecos;
    private List<TipoServicos>tipoServicos;
    private Planos plano;

    public AssistenciaVo(Assistencias assistencia) {
        this.id = assistencia.getId();
        this.telefonePrimario = assistencia.getTelefonePrimario();
        this.telefoneSecundario = assistencia.getTelefoneSecundario();
        this.representante = assistencia.getRepresentante();
        this.enderecos = assistencia.getEnderecos();
        this.tipoServicos = assistencia.getTipoServicos();
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

    public Representantes getRepresentante() {
        return representante;
    }

    public List<Enderecos> getEnderecos() {
        return enderecos;
    }

    public List<TipoServicos> getTipoServicos() {
        return tipoServicos;
    }

    public Planos getPlano() {
        return plano;
    }

    public static Page<AssistenciaVo> converter(Page<Assistencias> assistencias) {
        return assistencias.map(AssistenciaVo::new);
    }
}
