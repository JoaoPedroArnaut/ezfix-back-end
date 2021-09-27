package br.com.ezfix.api.controller.form;

import br.com.ezfix.api.model.Enderecos;
import br.com.ezfix.api.model.Solicitantes;
import br.com.ezfix.api.model.Usuarios;
import br.com.ezfix.api.model.compositekeys.EnderecoId;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.Arrays;

public class SolicitanteForm {

    private String email;
    private String senha;
    private Long cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String sexo;
    private Long telefonePrimario;
    private Long telefoneSecundario;
    private Long cep;
    private Long numero;
    private String complemento;

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public Long getTelefonePrimario() {
        return telefonePrimario;
    }

    public Long getTelefoneSecundario() {
        return telefoneSecundario;
    }

    public Long getCep() {
        return cep;
    }

    public Long getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public Solicitantes converterSolicitante(Usuarios usuarios, Enderecos enderecos){
        return new Solicitantes(this.getCpf(),
                this.getNome(),
                this.getDataNascimento(),
                this.getTelefonePrimario(),
                this.getTelefoneSecundario(),
                usuarios,
                Arrays.asList(enderecos));
    }

    public Enderecos converterEnderecos(Integer id){
        return new Enderecos(
                new EnderecoId(
                        Long.valueOf(id + 1),
                        this.getCep()),
                this.getNumero(),
                this.getComplemento()
        );
    }

    public Usuarios converterUsuarios(){
         return new Usuarios(this.getEmail(),new BCryptPasswordEncoder().encode(this.getSenha()));
    }
}
