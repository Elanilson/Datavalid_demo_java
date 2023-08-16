package com.apkdoandroid.datavalid_demo.model;

public class EnderecoB {

    /**
     * logradouro : true
     * logradouro_similaridade : 0
     * complemento : true
     * complemento_similaridade : 0
     * numero : true
     * numero_similaridade : 0
     * bairro : true
     * bairro_similaridade : 0
     * cep : true
     * municipio : true
     * municipio_similaridade : 0
     * uf : true
     */

    private boolean logradouro;
    private int logradouro_similaridade;
    private boolean complemento;
    private int complemento_similaridade;
    private boolean numero;
    private int numero_similaridade;
    private boolean bairro;
    private int bairro_similaridade;
    private boolean cep;
    private boolean municipio;
    private int municipio_similaridade;
    private boolean uf;

    public boolean isLogradouro() {
        return logradouro;
    }

    public void setLogradouro(boolean logradouro) {
        this.logradouro = logradouro;
    }

    public int getLogradouro_similaridade() {
        return logradouro_similaridade;
    }

    public void setLogradouro_similaridade(int logradouro_similaridade) {
        this.logradouro_similaridade = logradouro_similaridade;
    }

    public boolean isComplemento() {
        return complemento;
    }

    public void setComplemento(boolean complemento) {
        this.complemento = complemento;
    }

    public int getComplemento_similaridade() {
        return complemento_similaridade;
    }

    public void setComplemento_similaridade(int complemento_similaridade) {
        this.complemento_similaridade = complemento_similaridade;
    }

    public boolean isNumero() {
        return numero;
    }

    public void setNumero(boolean numero) {
        this.numero = numero;
    }

    public int getNumero_similaridade() {
        return numero_similaridade;
    }

    public void setNumero_similaridade(int numero_similaridade) {
        this.numero_similaridade = numero_similaridade;
    }

    public boolean isBairro() {
        return bairro;
    }

    public void setBairro(boolean bairro) {
        this.bairro = bairro;
    }

    public int getBairro_similaridade() {
        return bairro_similaridade;
    }

    public void setBairro_similaridade(int bairro_similaridade) {
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

    public int getMunicipio_similaridade() {
        return municipio_similaridade;
    }

    public void setMunicipio_similaridade(int municipio_similaridade) {
        this.municipio_similaridade = municipio_similaridade;
    }

    public boolean isUf() {
        return uf;
    }

    public void setUf(boolean uf) {
        this.uf = uf;
    }
}
