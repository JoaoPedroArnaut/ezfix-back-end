package br.com.ezfix.api.controller.form;

import br.com.ezfix.api.model.Assistencias;
import br.com.ezfix.api.model.Planos;
import br.com.ezfix.api.model.Representantes;
import br.com.ezfix.api.model.Usuarios;

import java.time.LocalDate;
import java.util.Arrays;

public class AssistenciaForm extends CadastroForm{

    private String documento;
    private String nome;
    private LocalDate dataNascimento;
    private Long telefonePrimario;
    private Long telefoneSecundario;
    private Long plano;

    private Representantes representantes;
    private Assistencias assistencias;

    public AssistenciaForm(String email, String senha, Long cep, Long numero, String complemento, String documento, String nome, LocalDate dataNascimento, Long telefonePrimario, Long telefoneSecundario, Long plano, Representantes representantes, Assistencias assistencias) {
        super(email, senha, cep, numero, complemento);
        this.documento = documento;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefonePrimario = telefonePrimario;
        this.telefoneSecundario = telefoneSecundario;
        this.plano = plano;
        this.representantes = representantes;
        this.assistencias = assistencias;
    }

    public Representantes getRepresentantes() {
        return representantes;
    }

    public Assistencias getAssistencias() {
        return assistencias;
    }

    public Long getPlano() {
        return plano;
    }

    public void converterRepresentantes(){
        this.representantes = new Representantes(this.documento,this.nome,this.dataNascimento,this.getUsuarios());
    }

    public void converterAssistencias(Planos plano){
        this.assistencias = new Assistencias(
                this.telefonePrimario,
                this.telefoneSecundario,
                this.representantes,
                Arrays.asList(super.getEnderecos()),
                plano
        );
    }

    @Override
    public String toString() {
        return "AssistenciaForm{" +
                "documento='" + documento + '\'' +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", telefonePrimario=" + telefonePrimario +
                ", telefoneSecundario=" + telefoneSecundario +
                ", plano=" + plano +
                ", representantes=" + representantes +
                ", assistencias=" + assistencias +
                '}';
    }
}
