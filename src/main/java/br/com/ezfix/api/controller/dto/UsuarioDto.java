package br.com.ezfix.api.controller.dto;

import br.com.ezfix.api.model.Usuario;
import org.springframework.data.domain.Page;

public class UsuarioDto {

    private Long id;
    private String email;

    public UsuarioDto(Usuario usuario){
        this.email = usuario.getEmail();
    }

    public String getEmail() {
        return email;
    }

    public static Page<UsuarioDto> converter(Page<Usuario> usuarios){
        return usuarios.map(UsuarioDto::new);
    }
}
