package br.com.ezfix.api.controller.response;

public class AvaliacoesTecnico {

    private String cpf;
    private String nome;
    private String comentario;
    private Double nota;

    public AvaliacoesTecnico(String cpf, String nome, String comentario, Double nota) {
        this.cpf = cpf;
        this.nome = nome;
        this.comentario = comentario;
        this.nota = nota;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getComentario() {
        return comentario;
    }

    public Double getNota() {
        return nota;
    }
}
