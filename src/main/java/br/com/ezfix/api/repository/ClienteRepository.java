package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Page<Cliente> findByNome(String nomeCliente, Pageable pagina);
}
