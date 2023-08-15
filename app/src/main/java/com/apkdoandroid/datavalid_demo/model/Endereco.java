package com.apkdoandroid.datavalid_demo.model;

public class Endereco {


    /**
     * logradouro : false
     * logradouro_similaridade : 0.16666666666666663
     * numero : false
     * numero_similaridade : 0.0
     * bairro : false
     * bairro_similaridade : 0.47058823529411764
     * cep : false
     * municipio : false
     * municipio_similaridade : 0.17647058823529416
     * uf : false
     */

    private boolean logradouro;
    private double logradouro_similaridade;
    private boolean numero;
    private double numero_similaridade;
    private boolean bairro;
    private double bairro_similaridade;
    private boolean cep;
    private boolean municipio;
    private double municipio_similaridade;
    private boolean uf;

    public boolean isLogradouro() {
        return logradouro;
    }

    public void setLogradouro(boolean logradouro) {
        this.logradouro = logradouro;
    }

    public double getLogradouro_similaridade() {
        return logradouro_similaridade;
    }

    public void setLogradouro_similaridade(double logradouro_similaridade) {
        this.logradouro_similaridade = logradouro_similaridade;
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

    public boolean isBairro() {
        return bairro;
    }

    public void setBairro(boolean bairro) {
        this.bairro = bairro;
    }

    public double getBairro_similaridade() {
        return bairro_similaridade;
    }

    public void setBairro_similaridade(double bairro_similaridade) {
        this.bairro_similaridade = bairro_similaridade;
    }

    public boolean isCep() {
        return cep;
    }

    public void setCep(boolean cep) {
        this.cep = cep;
    }

    public boolean isMunicipio() {
        return municipio;
    }

    public void setMunicipio(boolean municipio) {
        this.municipio = municipio;
    }

    public double getMunicipio_similaridade() {
        return municipio_similaridade;
    }

    public void setMunicipio_similaridade(double municipio_similaridade) {
        this.municipio_similaridade = municipio_similaridade;
    }

    public boolean isUf() {
        return uf;
    }

    public void setUf(boolean uf) {
        this.uf = uf;
    }
}
