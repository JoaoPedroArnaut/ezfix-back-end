package br.com.ezfix.api.controller.form;

import br.com.ezfix.api.model.Assistencia;
import br.com.ezfix.api.model.Plano;
import br.com.ezfix.api.model.Representante;

import java.time.LocalDate;
import java.util.Arrays;

public class AssistenciaForm extends CadastroForm{

    private String documento;
    private String nome;
    private String nomeFantasia;
    private LocalDate dataNascimento;
    private Long telefonePrimario;
    private Long telefoneSecundario;
    private Long plano;

    private Representante representante;
    private Assistencia assistencia;

    public AssistenciaForm(String email, String senha, Long cep, Long numero, String complemento, String documento, String nome, String nomeFantasia, LocalDate dataNascimento, Long telefonePrimario, Long telefoneSecundario, Long plano, Representante representante, Assistencia assistencia) {
        super(email, senha, cep, numero, complemento);
        this.documento = documento;
        this.nome = nome;
        this.nomeFantasia = nomeFantasia;
        this.dataNascimento = dataNascimento;
        this.telefonePrimario = telefonePrimario;
        this.telefoneSecundario = telefoneSecundario;
        this.plano = plano;
        this.representante = representante;
        this.assistencia = assistencia;
    }

    public Representante getRepresentantes() {
        return representante;
    }

    public Assistencia getAssistencias() {
        return assistencia;
    }

    public Long getPlano() {
        return plano;
    }

    public void converterRepresentantes(){
        this.representante = new Representante(this.documento,this.nome,this.dataNascimento,this.getUsuarios());
    }

    public void converterAssistencias(Plano plano){
        this.assistencia = new Assistencia(
                this.nomeFantasia,
                this.telefonePrimario,
                this.telefoneSecundario,
                this.representante,
                Arrays.asList(super.getEnderecos()),
                plano
        );
    }
}
