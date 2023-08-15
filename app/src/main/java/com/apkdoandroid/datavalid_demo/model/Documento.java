package com.apkdoandroid.datavalid_demo.model;

public class Documento {

    /**
     * tipo : true
     * numero : false
     * numero_similaridade : 0.0
     * orgao_expedidor : true
     * uf_expedidor : false
     */

    private boolean tipo;
    private boolean numero;
    private double numero_similaridade;
    private boolean orgao_expedidor;
    private boolean uf_expedidor;

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public boolean isNumero() {
        return numero;
    }

    public void setNumero(boolean numero) {
        this.numero = numero;
    }

    public double getNumero_similaridade() {
        return numero_similaridade;
    }

    public void setNumero_similaridade(double numero_similaridade) {
        this.numero_similaridade = numero_similaridade;
    }

    public boolean isOrgao_expedidor() {
        return orgao_expedidor;
    }

    public void setOrgao_expedidor(boolean orgao_expedidor) {
        this.orgao_expedidor = orgao_expedidor;
    }

    public boolean isUf_expedidor() {
        return uf_expedidor;
    }

    public void setUf_expedidor(boolean uf_expedidor) {
        this.uf_expedidor = uf_expedidor;
    }
}
