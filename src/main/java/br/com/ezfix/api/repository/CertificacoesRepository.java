package br.com.ezfix.api.repository;

import br.com.ezfix.api.controller.response.CertificadoSemAssistencia;
import br.com.ezfix.api.model.Certificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CertificacoesRepository extends JpaRepository<Certificacao,Long> {

    @Query("select new br.com.ezfix.api.controller.response.CertificadoSemAssistencia(c.nomeCurso,c.quantidadeHoras,c.dataInicio,c.dataConclusao) from Certificacao c where  c.assistencia.id = ?1")
    List<CertificadoSemAssistencia> todosCertificadosDeUmaAssistencia(Long id);
}
