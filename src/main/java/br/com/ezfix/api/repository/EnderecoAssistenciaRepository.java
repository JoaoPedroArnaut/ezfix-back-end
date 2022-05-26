package br.com.ezfix.api.repository;

import br.com.ezfix.api.controller.response.CidadeEstado;
import br.com.ezfix.api.model.EnderecoAssistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnderecoAssistenciaRepository extends JpaRepository<EnderecoAssistencia, Long> {

    @Query("select new br.com.ezfix.api.controller.response.CidadeEstado(e.enderecoEspecifico.enderecoGeral.cidade, e.enderecoEspecifico.enderecoGeral.estado) from EnderecoAssistencia e where e.assistencia.id = ?1")
    CidadeEstado obterCidadeEstadoPorIdAssistencia(Long id);
}
