package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfisRepository extends JpaRepository<Perfil,Long> {
}
