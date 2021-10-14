package br.com.ezfix.api.controller.vo;

import br.com.ezfix.api.model.Usuarios;
import org.springframework.data.domain.Page;

public class UsuarioDto {

    private Long id;
    private String email;

    public UsuarioDto(Usuarios usuarios){
        this.email = usuarios.getEmail();
    }

    public String getEmail() {
        return email;
    }

    public static Page<UsuarioDto> converter(Page<Usuarios> usuarios){
        return usuarios.map(UsuarioDto::new);
    }
}
