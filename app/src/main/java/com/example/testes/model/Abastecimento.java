package com.example.testes.model;

import java.util.Date;

public class Abastecimento {
    int id;
    Date dataAbastecimento;
    String kmAbastecimento;
    String litrosAbastecimento;
    String mesAnoAbastecimento;
    String placaAbastecimento;
    String localAbastecimento;
    String valorAbastecimento;
    String responsavelAbastecimento;
    String formaPagamento;
    Veiculo veiculo;
    Usuario usuario;

    public void setDataAbastecimento(Date dataAbastecimento) {
        this.dataAbastecimento = dataAbastecimento;
    }





    public Veiculo getVeiculo() {
        return veiculo;
    }

    @Override
    public String toString() {
        return "Abastecimento{" +
                "veiculo=" + veiculo +
                ", usuario=" + usuario +
                ", id=" + id +
                ", dataAbastecimento=" + dataAbastecimento +
                ", kmAbastecimento='" + kmAbastecimento + '\'' +
                ", litrosAbastecimento='" + litrosAbastecimento + '\'' +
                ", mesAnoAbastecimento='" + mesAnoAbastecimento + '\'' +
                ", placaAbastecimento='" + placaAbastecimento + '\'' +
                ", localAbastecimento='" + localAbastecimento + '\'' +
                ", valorAbastecimento='" + valorAbastecimento + '\'' +
                ", responsavelAbastecimento='" + responsavelAbastecimento + '\'' +
                ", formaPagamento='" + formaPagamento + '\'' +
                '}';
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }







    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataAbastecimento() {
        return dataAbastecimento;
    }

    public void setDataAbastecimento(java.sql.Date dataAbastecimento) {
        this.dataAbastecimento = dataAbastecimento;
    }

    public String getKmAbastecimento() {
        return kmAbastecimento;
    }

    public void setKmAbastecimento(String kmAbastecimento) {
        this.kmAbastecimento = kmAbastecimento;
    }

    public String getLitrosAbastecimento() {
        return litrosAbastecimento;
    }

    public void setLitrosAbastecimento(String litrosAbastecimento) {
        this.litrosAbastecimento = litrosAbastecimento;
    }

    public String getMesAnoAbastecimento() {
        return mesAnoAbastecimento;
    }

    public void setMesAnoAbastecimento(String mesAnoAbastecimento) {
        this.mesAnoAbastecimento = mesAnoAbastecimento;
    }

    public String getPlacaAbastecimento() {
        return placaAbastecimento;
    }

    public void setPlacaAbastecimento(String placaAbastecimento) {
        this.placaAbastecimento = placaAbastecimento;
    }

    public String getLocalAbastecimento() {
        return localAbastecimento;
    }

    public void setLocalAbastecimento(String localAbastecimento) {
        this.localAbastecimento = localAbastecimento;
    }

    public String getValorAbastecimento() {
        return valorAbastecimento;
    }

    public void setValorAbastecimento(String valorAbastecimento) {
        this.valorAbastecimento = valorAbastecimento;
    }

    public String getResponsavelAbastecimento() {
        return responsavelAbastecimento;
    }

    public void setResponsavelAbastecimento(String responsavelAbastecimento) {
        this.responsavelAbastecimento = responsavelAbastecimento;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }


}
