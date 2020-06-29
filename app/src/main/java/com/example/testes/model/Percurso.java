package com.example.testes.model;

import java.util.Date;

public class Percurso {
    int id;
    Itinerario itinerario;
    Usuario usuario;
    Veiculo veiculo;
    Date data;
    Integer kmInicial, KmFinal, kmTotal;
    String horaInicial, horaFinal;
    Vistoria vistoria;


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

    String MesAno;

    public Itinerario getItinerario() {
        return itinerario;
    }

    public void setItinerario(Itinerario itinerario) {
        this.itinerario = itinerario;
    }




    public String getMesAno() {
        return MesAno;
    }

    public void setMesAno(String mesAno) {
        MesAno = mesAno;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
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

    public Vistoria getVistoria() {
        return vistoria;
    }

    public void setVistoria(Vistoria vistoria) {
        this.vistoria = vistoria;
    }
}
