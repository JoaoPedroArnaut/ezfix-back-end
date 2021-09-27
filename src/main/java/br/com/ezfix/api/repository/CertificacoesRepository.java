package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Certificacoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificacoesRepository extends JpaRepository<Certificacoes,Long> {
}
