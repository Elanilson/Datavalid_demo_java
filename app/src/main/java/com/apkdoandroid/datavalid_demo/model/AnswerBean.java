package com.apkdoandroid.datavalid_demo.model;

public class AnswerBean {

    /**
     * documento : {"formato":"JPG","base64":"imagem base64"}
     * documento_verso : {"formato":"JPG","base64":"imagem base64"}
     * biometria_face : {"formato":"JPG","base64":"imagem base64"}
     */

    private DocumentoBean documento;
    private DocumentoBean documento_verso;
    private DocumentoBean biometria_face;

    public DocumentoBean getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentoBean documento) {
        this.documento = documento;
    }

    public DocumentoBean getDocumento_verso() {
        return documento_verso;
    }

    public void setDocumento_verso(DocumentoBean documento_verso) {
        this.documento_verso = documento_verso;
    }

    public DocumentoBean getBiometria_face() {
        return biometria_face;
    }

    public void setBiometria_face(DocumentoBean biometria_face) {
        this.biometria_face = biometria_face;
    }
}
