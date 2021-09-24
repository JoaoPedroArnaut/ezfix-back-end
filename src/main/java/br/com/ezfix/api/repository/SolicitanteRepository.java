package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Solicitante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitanteRepository extends JpaRepository<Solicitante, Long> {

    Page<Solicitante> findByNome(String nomeCliente, Pageable pagina);
}
