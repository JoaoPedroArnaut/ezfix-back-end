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
    private String telefonePrimario;
    private String telefoneSecundario;
    private Long plano;

    private Representante representante;
    private Assistencia assistencia;

    public AssistenciaForm(String email, String senha, Long cep, String logradouro, String bairro, String cidade, String estado, Long numero, String complemento, String documento, String nome, String nomeFantasia, String dataNascimento, String telefonePrimario, String telefoneSecundario, Long plano) {
        super(email, senha, cep, logradouro, bairro, cidade, estado, numero, complemento,dataNascimento);
        this.documento = documento;
        this.nome = nome;
        this.nomeFantasia = nomeFantasia;
        this.telefonePrimario = telefonePrimario;
        this.telefoneSecundario = telefoneSecundario;
        this.plano = plano;
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

    public String getDocumento() {
        return documento;
    }

    public void converterRepresentantes(){
        this.representante = new Representante(this.documento,this.nome,super.getDataNascimento(),this.getUsuarios());
    }

    public void converterAssistencias(Plano plano){
        this.assistencia = new Assistencia(
                this.nomeFantasia,
                this.telefonePrimario,
                this.telefoneSecundario,
                this.representante,
                plano
        );
    }
}
