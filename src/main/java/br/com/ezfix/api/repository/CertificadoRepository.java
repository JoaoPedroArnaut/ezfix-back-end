package br.com.ezfix.api.repository;

import br.com.ezfix.api.controller.response.CertificadoSemAnexo;
import br.com.ezfix.api.controller.response.CertificadoSemAssistencia;
import br.com.ezfix.api.model.Certificado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CertificadoRepository extends JpaRepository<Certificado,Long> {

    @Query("select new br.com.ezfix.api.controller.response.CertificadoSemAnexo( c.id, c.nomeCurso, c.quantidadeHoras ,c.dataInicio ,c.dataConclusao ) from Certificado c where c.assistencia.id = ?1")
    List<CertificadoSemAnexo> getCertificadosSemAnexo(Long id);
}
