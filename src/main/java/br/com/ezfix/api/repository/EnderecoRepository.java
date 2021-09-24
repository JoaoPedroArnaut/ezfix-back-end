package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Endereco;
import br.com.ezfix.api.model.compositekeys.EnderecoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, EnderecoId> {
}
