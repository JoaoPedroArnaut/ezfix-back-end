package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.EnderecoEspecifico;
import br.com.ezfix.api.model.EnderecosSolicitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnderecosSolicitanteRepository extends JpaRepository<EnderecosSolicitante, Long> {

    @Query("select e.enderecoEspecifico from EnderecosSolicitante e where e.solicitante.cpf = ?1")
    List<EnderecoEspecifico> getEnderecos(String cpf);
}
