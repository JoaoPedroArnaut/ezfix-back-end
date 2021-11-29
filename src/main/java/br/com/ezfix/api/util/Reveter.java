package br.com.ezfix.api.util;

import org.springframework.data.jpa.repository.JpaRepository;

public class Reveter {

    private JpaRepository repository;
    private Object id;

    public Reveter(JpaRepository repository, Object id) {
        this.repository = repository;
        this.id = id;
    }

    public void revert(){
        if (this.repository.existsById(this.id)){
            this.repository.deleteById(this.id);
        }
    }

    public Object getId() {
        return id;
    }
}
