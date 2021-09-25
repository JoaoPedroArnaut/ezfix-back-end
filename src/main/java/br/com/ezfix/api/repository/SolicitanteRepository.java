package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Solicitantes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitanteRepository extends JpaRepository<Solicitantes, Long> {

    Page<Solicitantes> findByNome(String nomeCliente, Pageable pagina);
}
