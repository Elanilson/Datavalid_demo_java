package com.apkdoandroid.datavalid_demo.model;

public class CNAE_principal {

    /**
     * codigo : true
     * descricao : true
     * descricao_similaridade : 1.0
     */

    private boolean codigo;
    private boolean descricao;
    private double descricao_similaridade;

    public boolean isCodigo() {
        return codigo;
    }

    public void setCodigo(boolean codigo) {
        this.codigo = codigo;
    }

    public boolean isDescricao() {
        return descricao;
    }

    public void setDescricao(boolean descricao) {
        this.descricao = descricao;
    }

    public double getDescricao_similaridade() {
        return descricao_similaridade;
    }

    public void setDescricao_similaridade(double descricao_similaridade) {
        this.descricao_similaridade = descricao_similaridade;
    }
}
