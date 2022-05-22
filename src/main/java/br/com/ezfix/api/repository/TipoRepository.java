package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<Tipo, Long> {
}
