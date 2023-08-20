package com.apkdoandroid.datavalid_demo.model;

public class PF_Facil_CDVResult {
    private String documento;
    private CNH cnh;
    private BiometriaFacial biometria_face;
    /**
     * message : Imagem da face não encontrada nas bases
     * code : DV040
     */

    private String message;
    private String code;
    /**
     * property : documento
     */

    private String property;


    @Override
    public String toString() {
        return "PF_Facil_CDVResult{" +
                "documento='" + documento + '\'' +
                ", cnh=" + cnh +
                ", biometria_face=" + biometria_face +
                ", message='" + message + '\'' +
                ", code='" + code + '\'' +
                ", property='" + property + '\'' +
                '}';
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public CNH getCnh() {
        return cnh;
    }

    public void setCnh(CNH cnh) {
        this.cnh = cnh;
    }

    public BiometriaFacial getBiometria_face() {
        return biometria_face;
    }

    public void setBiometria_face(BiometriaFacial biometria_face) {
        this.biometria_face = biometria_face;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
