package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Orcamento;
import br.com.ezfix.api.util.FilaObj;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {

    List<Orcamento> findAllByAssistenciaId(Long id);
    List<Orcamento> findAllBySolicitanteCpf(String cpf);
    List<Orcamento> findAllByAssistenciaIdAndStatusGeral(Long id,String status);
}
