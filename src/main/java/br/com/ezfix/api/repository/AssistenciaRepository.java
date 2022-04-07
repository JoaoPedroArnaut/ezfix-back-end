package br.com.ezfix.api.repository;

import br.com.ezfix.api.controller.response.CardAsssitencia;
import br.com.ezfix.api.controller.response.PerfilAssistencia;
import br.com.ezfix.api.model.Assistencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AssistenciaRepository extends JpaRepository<Assistencia,Long> {

    Assistencia findByRepresentanteUsuarioEmail(String email);
    Assistencia findFirstByOrderByIdDesc();

    @Transactional
    @Modifying
    @Query("update Assistencia  a set a.telefonePrimario = ?2, a.telefoneSecundario = ?3  where a.id = ?1")
    void atualizaTelefone(Long id, String tel1,String tel2);


    @Query("select new br.com.ezfix.api.controller.response.CardAsssitencia(a.id,a.nomeFantasia,a.avaliacao,a.enderecoEspecificos.enderecoGeral.cidade,a.enderecoEspecificos.enderecoGeral.bairro) from Assistencia a")
    Page<CardAsssitencia> todosCardAssistencia(Pageable pageable);

    @Query("select new br.com.ezfix.api.controller.response.PerfilAssistencia(a.nomeFantasia,a.avaliacao,a.enderecoEspecificos.enderecoGeral.cidade,a.enderecoEspecificos.enderecoGeral.estado) from Assistencia a where  a.id = ?1")
    PerfilAssistencia buscaPerfilAssistenciaPorId(Long id);
}
