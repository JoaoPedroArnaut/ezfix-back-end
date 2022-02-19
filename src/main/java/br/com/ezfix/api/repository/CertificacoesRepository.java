package br.com.ezfix.api.repository;

import br.com.ezfix.api.controller.response.CertificadoSemAssistencia;
import br.com.ezfix.api.model.Certificado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CertificacoesRepository extends JpaRepository<Certificado,Long> {
}
