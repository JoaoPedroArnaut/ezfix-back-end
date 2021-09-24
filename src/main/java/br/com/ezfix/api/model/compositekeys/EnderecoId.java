package br.com.ezfix.api.model.compositekeys;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
public class EnderecoId implements Serializable {

    private Long id;
    private Long cep;

    public EnderecoId() {
    }

    public EnderecoId(Long id, Long cep) {
        this.id = id;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }
}
