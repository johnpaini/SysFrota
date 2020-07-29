package com.example.testes.model;

import java.util.Date;

public class Percurso {
    int id;
    int itinerario;
    int usuario;
    int veiculo;
    Date data;
    Integer kmInicial, KmFinal, kmTotal;
    String horaInicial, horaFinal;
    int vistoria;
    String MesAno;

    @Override
    public String toString() {
        return "Percurso{" +
                "itinerario=" + itinerario +
                ", MesAno='" + MesAno + '\'' +
                ", usuario=" + usuario +
                ", veiculo=" + veiculo +
                ", data=" + data +
                ", kmInicial=" + kmInicial +
                ", KmFinal=" + KmFinal +
                ", kmTotal=" + kmTotal +
                ", horaInicial='" + horaInicial + '\'' +
                ", horaFinal='" + horaFinal + '\'' +
                ", vistoria=" + vistoria +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItinerario() {
        return itinerario;
    }

    public void setItinerario(int itinerario) {
        this.itinerario = itinerario;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(int veiculo) {
        this.veiculo = veiculo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getKmInicial() {
        return kmInicial;
    }

    public void setKmInicial(Integer kmInicial) {
        this.kmInicial = kmInicial;
    }

    public Integer getKmFinal() {
        return KmFinal;
    }

    public void setKmFinal(Integer kmFinal) {
        KmFinal = kmFinal;
    }

    public Integer getKmTotal() {
        return kmTotal;
    }

    public void setKmTotal(Integer kmTotal) {
        this.kmTotal = kmTotal;
    }

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public int getVistoria() {
        return vistoria;
    }

    public void setVistoria(int vistoria) {
        this.vistoria = vistoria;
    }

    public String getMesAno() {
        return MesAno;
    }

    public void setMesAno(String mesAno) {
        MesAno = mesAno;
    }


}
