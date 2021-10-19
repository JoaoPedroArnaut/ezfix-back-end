package br.com.ezfix.api.controller.form;

import br.com.ezfix.api.model.Solicitante;

import java.time.LocalDate;
import java.util.Arrays;

public class SolicitanteForm extends CadastroForm{

    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private Long telefonePrimario;
    private Long telefoneSecundario;

    private Solicitante solicitante;

    public SolicitanteForm(String email, String senha, Long cep, Long numero, String complemento, String cpf, String nome, LocalDate dataNascimento, Long telefonePrimario, Long telefoneSecundario) {
        super(email, senha, cep, numero, complemento);
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefonePrimario = telefonePrimario;
        this.telefoneSecundario = telefoneSecundario;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void converterSolicitante(){
        solicitante = new Solicitante(this.cpf,
                this.nome,
                this.dataNascimento,
                this.telefonePrimario,
                this.telefoneSecundario,
                super.getUsuarios(),
                Arrays.asList(super.getEnderecos()));
    }
}
