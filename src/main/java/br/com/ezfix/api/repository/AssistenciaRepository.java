package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Assistencias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssistenciaRepository extends JpaRepository<Assistencias ,Long> {
}
