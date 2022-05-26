package br.com.ezfix.api.repository;

import br.com.ezfix.api.controller.response.ItemOrcamentoOnlyNames;
import br.com.ezfix.api.controller.response.ItemOrcamentoSimples;
import br.com.ezfix.api.model.ItemOrcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemOrcamentoRepository extends JpaRepository<ItemOrcamento, Long> {


    @Query("select new br.com.ezfix.api.controller.response.ItemOrcamentoSimples(i.produto.marca.nome, i.produto.modelo.nome) from ItemOrcamento i join i.produto where i.orcamento.id = ?1")
    List<ItemOrcamentoSimples> getItemOrcamento(Long id);

    @Query("select new br.com.ezfix.api.controller.response.ItemOrcamentoOnlyNames(i.descricao,i.produto.marca.nome,i.produto.tipo.nome,i.produto.modelo.nome) from ItemOrcamento i where i.orcamento.id = ?1")
    List<ItemOrcamentoOnlyNames> getItemOrcamentoOnlyNames(Long id);
}
