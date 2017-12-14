package br.ufjf.dcc196.ana.taskapp.model;

import java.io.Serializable;

public class Tag implements Serializable{
    private int id;
    private String nome;

    public Tag(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Tag(String nome) {
        this.nome = nome;
    }

    public Tag(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
