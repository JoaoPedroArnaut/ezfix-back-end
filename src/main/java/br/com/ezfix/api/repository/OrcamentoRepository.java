package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Orcamento;
import br.com.ezfix.api.util.FilaObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {

    List<Orcamento> findAllByAssistenciaId(Long id);
    List<Orcamento> findAllBySolicitanteCpf(String cpf);
    List<Orcamento> findAllByAssistenciaIdAndStatusGeral(Long id,String status);

    @Query("select count(all o) from Orcamento o where o.assistencia.id = ?1 and o.dataCriacao = current_date")
    Long totalOrcamentoDia(Long id);

    @Transactional
    @Modifying
    @Query("update Orcamento o set o.statusGeral = ?2 where o.id = ?1")
    void atualizaStatus(Long id,String status);
}
