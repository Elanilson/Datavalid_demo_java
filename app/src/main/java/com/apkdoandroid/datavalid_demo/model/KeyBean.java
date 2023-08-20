package com.apkdoandroid.datavalid_demo.model;

public class KeyBean {
    /**
     * cpf : 11295395045
     */

    private String cpf;

    @Override
    public String toString() {
        return "KeyBean{" +
                "cpf='" + cpf + '\'' +
                '}';
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
