package com.example.banco2adapters;

public class Aluno {
    int _id;
    String _nome;

    public Aluno() {
        this._id = 0;
        this._nome = "";
    }

    public Aluno(int id, String nome) {
        this._id = id;
        this._nome = nome;
    }

    public Aluno(String nome){
        this._nome=nome;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_nome() {
        return _nome;
    }

    public void set_nome(String _nome) {
        this._nome = _nome;
    }
}
