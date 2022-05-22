package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
}
