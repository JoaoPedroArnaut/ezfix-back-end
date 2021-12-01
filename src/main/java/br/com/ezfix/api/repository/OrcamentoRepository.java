package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Orcamento;
import br.com.ezfix.api.util.FilaObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {

    List<Orcamento> findAllByAssistenciaId(Long id);
    List<Orcamento> findAllBySolicitanteCpf(String cpf);
    List<Orcamento> findAllByAssistenciaIdAndStatusGeral(Long id,String status);

    @Query("select count(all o) from Orcamento o where o.assistencia.id = ?1 and o.dataCriacao = current_date")
    Long totalOrcamentoDia(Long id);
}
