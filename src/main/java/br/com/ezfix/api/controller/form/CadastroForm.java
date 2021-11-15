package br.com.ezfix.api.controller.form;

import br.com.ezfix.api.model.EnderecoEspecifico;
import br.com.ezfix.api.model.EnderecoGeral;
import br.com.ezfix.api.model.Perfil;
import br.com.ezfix.api.model.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public abstract class CadastroForm {

    private String email;
    private String senha;
    private Long cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private Long numero;
    private String complemento;

    private Usuario usuario;
    private EnderecoGeral enderecoGeral;
    private EnderecoEspecifico enderecoEspecifico;

    public Long getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public Usuario getUsuarios() {
        return usuario;
    }

    public String getEmail() {
        return email;
    }

    public Long getCep() {
        return cep;
    }

    public EnderecoEspecifico getEnderecoEspecifico() {
        return enderecoEspecifico;
    }

    public EnderecoGeral getEnderecosGeral() {
        return enderecoGeral;
    }

    public CadastroForm(String email, String senha, Long cep, String logradouro, String bairro, String cidade, String estado, Long numero, String complemento) {
        this.email = email;
        this.senha = senha;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void converterUsuarios(Perfil perfil){
        this.usuario = new Usuario(this.email,new BCryptPasswordEncoder().encode(this.senha), perfil);
    }

    public void converterEnderecosGeral(){
        this.enderecoGeral = new EnderecoGeral(
                this.cep,
                this.logradouro,
                this.bairro,
                this.cidade,
                this.estado
        );
    }

    public void convverterEnderecoEspecifico(){
        this.enderecoEspecifico = new EnderecoEspecifico(this.getNumero(),this.getComplemento(),this.getEnderecosGeral());
    }
}
