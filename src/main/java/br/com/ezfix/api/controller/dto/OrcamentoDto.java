package br.com.ezfix.api.controller.dto;

import br.com.ezfix.api.model.Assistencia;
import br.com.ezfix.api.model.ItemOrcamento;
import br.com.ezfix.api.model.Orcamento;
import br.com.ezfix.api.model.Solicitante;
import org.springframework.data.domain.Page;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

public class OrcamentoDto {

    private Long id;
    private Double valorTotal;
    private String statusGeral;
    private Solicitante solicitante;
    private Assistencia assistencia;
    private List<ItemOrcamento> itens;

    public OrcamentoDto(Orcamento orcamento) {
        this.id = orcamento.getId();
        this.valorTotal = orcamento.getValorTotal();
        this.statusGeral = orcamento.getStatusGeral();
        this.solicitante = orcamento.getSolicitante();
        this.assistencia = orcamento.getAssistencia();
        this.itens = orcamento.getItens();
    }

    public Long getId() {
        return id;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public String getStatusGeral() {
        return statusGeral;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public Assistencia getAssistencia() {
        return assistencia;
    }

    public List<ItemOrcamento> getItens() {
        return itens;
    }

    public static Page<OrcamentoDto> converter(Page<Orcamento> orcamentos) {
        return orcamentos.map(OrcamentoDto::new);
    }
}
