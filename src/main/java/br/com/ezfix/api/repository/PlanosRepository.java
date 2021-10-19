package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Plano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanosRepository extends JpaRepository<Plano,Long> {
}
