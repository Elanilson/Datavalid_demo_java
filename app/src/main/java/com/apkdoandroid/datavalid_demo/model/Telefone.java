package com.apkdoandroid.datavalid_demo.model;

public class Telefone {

    /**
     * ddd : true
     * numero : true
     */

    private boolean ddd;
    private boolean numero;

    public boolean isDdd() {
        return ddd;
    }

    public void setDdd(boolean ddd) {
        this.ddd = ddd;
    }

    public boolean isNumero() {
        return numero;
    }

    public void setNumero(boolean numero) {
        this.numero = numero;
    }
}
