package br.com.ezfix.api.config.security;

import br.com.ezfix.api.model.Usuario;
import br.com.ezfix.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(s);

        if(usuario.isPresent()) {return usuario.get();}
        throw new UsernameNotFoundException("Dados Invalidos");
    }
}
