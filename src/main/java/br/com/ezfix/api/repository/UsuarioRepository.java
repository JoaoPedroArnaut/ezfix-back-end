package br.com.ezfix.api.repository;

import br.com.ezfix.api.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuarios, String> {

    Optional<Usuarios> findByEmail(String email);
}
