package br.com.ezfix.api.controller.vo;

import br.com.ezfix.api.model.Usuarios;
import org.springframework.data.domain.Page;

public class UsuarioVo {

    private Long id;
    private String email;

    public UsuarioVo(Usuarios usuarios){
        this.email = usuarios.getEmail();
    }

    public String getEmail() {
        return email;
    }

    public static Page<UsuarioVo> converter(Page<Usuarios> usuarios){
        return usuarios.map(UsuarioVo::new);
    }
}
