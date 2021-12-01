package br.com.ezfix.api.repository;

import br.com.ezfix.api.controller.response.AvaliacoesTecnico;
import br.com.ezfix.api.controller.response.SistemaAvaliacao;
import br.com.ezfix.api.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    List<Comentario> findAllByAssistenciaId(Long id);

    @Query("select new br.com.ezfix.api.controller.response.SistemaAvaliacao(c.avaliacao) from Comentario c where c.assistencia.id = ?1")
    List<SistemaAvaliacao> apenasAsAvaliacoes(Long id);

    @Query("select new br.com.ezfix.api.controller.response.AvaliacoesTecnico(c.solicitante.cpf,c.solicitante.nome,c.comentario,c.avaliacao) from Comentario c where c.assistencia.id = ?1 order by c.id desc")
    List<AvaliacoesTecnico> SomenteNecessaario(Long id);

    @Query("select count(all c) from Comentario c where c.assistencia.id = ?1 and c.dataComentario = current_date")
    Long contarTodosComentariosHoje(Long id);
}
