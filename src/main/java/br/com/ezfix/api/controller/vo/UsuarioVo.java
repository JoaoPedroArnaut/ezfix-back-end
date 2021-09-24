package br.com.ezfix.api.controller.vo;

import br.com.ezfix.api.model.Usuario;
import org.springframework.data.domain.Page;

public class UsuarioVo {

    private Long id;
    private String email;

    public UsuarioVo(Usuario usuario){
        this.email = usuario.getEmail();
    }

    public String getEmail() {
        return email;
    }

    public static Page<UsuarioVo> converter(Page<Usuario> usuarios){
        return usuarios.map(UsuarioVo::new);
    }
}
