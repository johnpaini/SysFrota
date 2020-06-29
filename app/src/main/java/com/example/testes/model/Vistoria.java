package com.example.testes.model;

import java.util.Date;

public class Vistoria {
    int id;
    boolean documentos,luzes, pneus,chaveRoda,estepe, macaco, lataria ;
    String observacoesGerais;
    Date dataVistoria;
    Veiculo veiculo;


    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    public Date getDataVistoria() {
        return dataVistoria;
    }

    public void setDataVistoria(Date dataVistoria) {
        this.dataVistoria = dataVistoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDocumentos() {
        return documentos;
    }

    public void setDocumentos(boolean documentos) {
        this.documentos = documentos;
    }

    public boolean isLuzes() {
        return luzes;
    }

    public void setLuzes(boolean luzes) {
        this.luzes = luzes;
    }

    public boolean isPneus() {
        return pneus;
    }

    public void setPneus(boolean pneus) {
        this.pneus = pneus;
    }

    public boolean isChaveRoda() {
        return chaveRoda;
    }

    public void setChaveRoda(boolean chaveRoda) {
        this.chaveRoda = chaveRoda;
    }

    public boolean isEstepe() {
        return estepe;
    }

    public void setEstepe(boolean estepe) {
        this.estepe = estepe;
    }

    @Override
    public String toString() {
        return "Vistoria{" +
                "veiculo=" + veiculo +
                ", id=" + id +
                ", documentos=" + documentos +
                ", luzes=" + luzes +
                ", pneus=" + pneus +
                ", chaveRoda=" + chaveRoda +
                ", estepe=" + estepe +
                ", macaco=" + macaco +
                ", lataria=" + lataria +
                ", observacoesGerais='" + observacoesGerais + '\'' +
                ", dataVistoria=" + dataVistoria +
                '}';
    }

    public boolean isMacaco() {
        return macaco;
    }

    public void setMacaco(boolean macaco) {
        this.macaco = macaco;
    }

    public boolean isLataria() {
        return lataria;
    }

    public void setLataria(boolean lataria) {
        this.lataria = lataria;
    }

    public String getObservacoesGerais() {
        return observacoesGerais;
    }

    public void setObservacoesGerais(String observacoesGerais) {
        this.observacoesGerais = observacoesGerais;
    }
}
