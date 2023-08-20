package com.apkdoandroid.datavalid_demo.model;

public class DocumentoBean {
    @Override
    public String toString() {
        return "DocumentoBean{" +
                "formato='" + formato + '\'' +
                ", base64='" + base64 + '\'' +
                '}';
    }

    /**
     * formato : JPG
     * base64 : imagem base64
     */

    private String formato;
    private String base64;

    public DocumentoBean() {
    }

    public DocumentoBean(String formato, String base64) {
        this.formato = formato;
        this.base64 = base64;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}
