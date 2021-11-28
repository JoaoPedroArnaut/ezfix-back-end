package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    List<Comentario> findAllByAssistenciaId(Long id);
}
