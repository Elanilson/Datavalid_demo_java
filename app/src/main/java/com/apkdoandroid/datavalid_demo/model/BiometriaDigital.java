package com.apkdoandroid.datavalid_demo.model;

import java.util.ArrayList;
import java.util.List;

public class BiometriaDigital {


    /**
     * disponivel : true
     * digitais : [{"posicao":0,"probabilidade":"Altíssima probabilidade","similaridade":0}]
     */

    private boolean disponivel;
    private List<Digital> digitais = new ArrayList<>();

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public List<Digital> getDigitais() {
        return digitais;
    }

    public void setDigitais(List<Digital> digitais) {
        this.digitais = digitais;
    }
}
