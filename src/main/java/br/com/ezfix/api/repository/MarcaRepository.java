package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
