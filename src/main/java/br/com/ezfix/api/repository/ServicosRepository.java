package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicosRepository extends JpaRepository<Servico,Long> {
}
