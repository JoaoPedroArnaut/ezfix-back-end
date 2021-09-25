package br.com.ezfix.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Representante {

    @Id
    private String documento;
}
