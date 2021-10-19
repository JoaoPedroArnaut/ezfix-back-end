package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Certificacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificacoesRepository extends JpaRepository<Certificacao,Long> {
}
