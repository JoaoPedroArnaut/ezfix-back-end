package br.com.ezfix.api.controller.form;

import br.com.ezfix.api.model.Endereco;
import br.com.ezfix.api.model.Perfil;
import br.com.ezfix.api.model.Usuario;
import br.com.ezfix.api.model.compositekeys.EnderecoId;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public abstract class CadastroForm {

    private String email;
    private String senha;
    private Long cep;
    private Long numero;
    private String complemento;

    private Usuario usuario;
    private Endereco endereco;

    public Long getCep() {
        return cep;
    }

    public Usuario getUsuarios() {
        return usuario;
    }

    public Endereco getEnderecos() {
        return endereco;
    }

    public CadastroForm(String email, String senha, Long cep, Long numero, String complemento) {
        this.email = email;
        this.senha = senha;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void converterUsuarios(Perfil perfil){
        this.usuario = new Usuario(this.email,new BCryptPasswordEncoder().encode(this.senha), perfil);
    }

    public void converterEnderecos(Integer id){
        endereco = new Endereco(
                new EnderecoId(
                        Long.valueOf(id + 1),
                        this.cep),
                this.numero,
                this.complemento
        );
    }
}
