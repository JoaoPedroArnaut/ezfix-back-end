package br.com.ezfix.api.repository;

import br.com.ezfix.api.controller.response.PerfilSolicitante;
import br.com.ezfix.api.controller.response.UsuarioSimples;
import br.com.ezfix.api.model.Solicitante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SolicitanteRepository extends JpaRepository<Solicitante, String> {

    Page<Solicitante> findByNome(String nomeCliente, Pageable pagina);

    Solicitante findByUsuarioEmail(String email);

    @Query("select new br.com.ezfix.api.controller.response.UsuarioSimples(s.cpf,s.nome) from Solicitante s inner join Usuario u on u.email = s.usuario.email where s.usuario.email = ?1")
    UsuarioSimples getUsuarioSimples(String email);

    @Query("select s.cpf from Solicitante s where s.usuario.email = ?1")
    String getCpfByEmail(String email);

    @Query("select new br.com.ezfix.api.controller.response.PerfilSolicitante(s.cpf,s.usuario.email,s.nome,s.telefonePrimario,s.telefoneSecundario) from Solicitante s inner join Usuario u on u.email = s.usuario.email where s.usuario.email = ?1")
    PerfilSolicitante getPerfilSolicitante(String email);
}
