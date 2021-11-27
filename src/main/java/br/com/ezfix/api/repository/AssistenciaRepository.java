package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Assistencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssistenciaRepository extends JpaRepository<Assistencia,Long> {

    Assistencia findByRepresentanteUsuarioEmail(String email);
}
