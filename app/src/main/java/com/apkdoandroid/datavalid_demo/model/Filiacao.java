package com.apkdoandroid.datavalid_demo.model;

public class Filiacao {


    /**
     * nome_mae : false
     * nome_mae_similaridade : 0.30000000000000004
     * nome_pai : false
     * nome_pai_similaridade : 0.23809523809523814
     */

    private boolean nome_mae;
    private double nome_mae_similaridade;
    private boolean nome_pai;
    private double nome_pai_similaridade;

    public boolean isNome_mae() {
        return nome_mae;
    }

    public void setNome_mae(boolean nome_mae) {
        this.nome_mae = nome_mae;
    }

    public double getNome_mae_similaridade() {
        return nome_mae_similaridade;
    }

    public void setNome_mae_similaridade(double nome_mae_similaridade) {
        this.nome_mae_similaridade = nome_mae_similaridade;
    }

    public boolean isNome_pai() {
        return nome_pai;
    }

    public void setNome_pai(boolean nome_pai) {
        this.nome_pai = nome_pai;
    }

    public double getNome_pai_similaridade() {
        return nome_pai_similaridade;
    }

    public void setNome_pai_similaridade(double nome_pai_similaridade) {
        this.nome_pai_similaridade = nome_pai_similaridade;
    }
}
