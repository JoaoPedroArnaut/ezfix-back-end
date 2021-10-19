package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {

    List<Orcamento> findAllByAssistenciaId(Long id);
}
