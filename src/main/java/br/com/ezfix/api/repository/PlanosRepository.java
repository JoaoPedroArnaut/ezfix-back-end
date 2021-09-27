package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Planos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanosRepository extends JpaRepository<Planos ,Long> {
}
