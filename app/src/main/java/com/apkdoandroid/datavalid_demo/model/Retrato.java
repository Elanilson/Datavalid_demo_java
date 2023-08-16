package com.apkdoandroid.datavalid_demo.model;

public class Retrato {


    /**
     * disponivel : true
     * probabilidade : Altíssima probabilidade
     * similaridade : 0.9956858549207501
     */

    private boolean disponivel;
    private String probabilidade;
    private double similaridade;

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getProbabilidade() {
        return probabilidade;
    }

    public void setProbabilidade(String probabilidade) {
        this.probabilidade = probabilidade;
    }

    public double getSimilaridade() {
        return similaridade;
    }

    public void setSimilaridade(double similaridade) {
        this.similaridade = similaridade;
    }
}
