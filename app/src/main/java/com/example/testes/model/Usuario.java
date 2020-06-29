package com.example.testes.model;

import java.util.Date;

public class Usuario {
    int id;
    String nome;
    String cpf;
    String senha;
    String unidade;
    String dataNascimento;
    //foto

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", senha='" + senha + '\'' +
                ", unidade='" + unidade + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }


    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    Date dataCadastro;


    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public String getUnidade() {
        return unidade;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }


}
