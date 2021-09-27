package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Representantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepresentanteRepository extends JpaRepository<Representantes ,String> {
}
