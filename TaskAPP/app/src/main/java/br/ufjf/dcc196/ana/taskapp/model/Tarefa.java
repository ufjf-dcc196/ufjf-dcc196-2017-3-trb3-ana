package br.ufjf.dcc196.ana.taskapp.model;

import java.io.Serializable;

public class Tarefa implements Serializable {
    private int id;
    private String titulo;
    private String descricao;
    private int grau_dificuldade;
    private int estado;

    public Tarefa() {}

    public Tarefa(int id, String titulo, String descricao, int grau_dificuldade, int estado) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.grau_dificuldade = grau_dificuldade;
        this.estado = estado;
    }

    public Tarefa(String titulo, String descricao, int grau_dificuldade, int estado) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.grau_dificuldade = grau_dificuldade;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getGrau_dificuldade() {
        return grau_dificuldade;
    }

    public void setGrau_dificuldade(int grau_dificuldade) {
        this.grau_dificuldade = grau_dificuldade;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
