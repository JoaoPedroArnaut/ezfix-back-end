package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Assistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AssistenciaRepository extends JpaRepository<Assistencia,Long> {

    Assistencia findByRepresentanteUsuarioEmail(String email);
    Assistencia findFirstByOrderByIdDesc();

    @Transactional
    @Modifying
    @Query("update Assistencia  a set a.telefonePrimario = ?2, a.telefoneSecundario = ?3  where a.id = ?1")
    void atualizaTelefone(Long id, String tel1,String tel2);
}
