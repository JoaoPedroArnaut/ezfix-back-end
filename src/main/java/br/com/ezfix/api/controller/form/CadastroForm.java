package br.com.ezfix.api.controller.form;

import br.com.ezfix.api.model.Enderecos;
import br.com.ezfix.api.model.Perfis;
import br.com.ezfix.api.model.Usuarios;
import br.com.ezfix.api.model.compositekeys.EnderecoId;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public abstract class CadastroForm {

    private String email;
    private String senha;
    private Long cep;
    private Long numero;
    private String complemento;

    private Usuarios usuarios;
    private Enderecos enderecos;

    public Long getCep() {
        return cep;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public Enderecos getEnderecos() {
        return enderecos;
    }

    public CadastroForm(String email, String senha, Long cep, Long numero, String complemento) {
        this.email = email;
        this.senha = senha;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void converterUsuarios(Perfis perfis){
        this.usuarios = new Usuarios(this.email,new BCryptPasswordEncoder().encode(this.senha),perfis);
    }

    public void converterEnderecos(Integer id){
        enderecos = new Enderecos(
                new EnderecoId(
                        Long.valueOf(id + 1),
                        this.cep),
                this.numero,
                this.complemento
        );
    }
}
