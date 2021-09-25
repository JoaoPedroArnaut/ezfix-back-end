package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Enderecos;
import br.com.ezfix.api.model.compositekeys.EnderecoId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Enderecos, EnderecoId> {

    List<Enderecos> findAllByEnderecoIdCep(Long cep);
}
