package com.apkdoandroid.datavalid_demo.model;

public class SituacaoCadastral {

    /**
     * codigo : true
     * data : true
     * motivo : true
     * motivo_similaridade : 1.0
     */

    private boolean codigo;
    private boolean data;
    private boolean motivo;
    private double motivo_similaridade;

    public boolean isCodigo() {
        return codigo;
    }

    public void setCodigo(boolean codigo) {
        this.codigo = codigo;
    }

    public boolean isData() {
        return data;
    }

    public void setData(boolean data) {
        this.data = data;
    }

    public boolean isMotivo() {
        return motivo;
    }

    public void setMotivo(boolean motivo) {
        this.motivo = motivo;
    }

    public double getMotivo_similaridade() {
        return motivo_similaridade;
    }

    public void setMotivo_similaridade(double motivo_similaridade) {
        this.motivo_similaridade = motivo_similaridade;
    }
}
