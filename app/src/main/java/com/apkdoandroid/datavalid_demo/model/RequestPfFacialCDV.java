package com.apkdoandroid.datavalid_demo.model;

public class RequestPfFacialCDV {

    /**
     * key : {"cpf":11295395045}
     * answer : {"documento":{"formato":"JPG","base64":"imagem base64"},"documento_verso":{"formato":"JPG","base64":"imagem base64"},"biometria_face":{"formato":"JPG","base64":"imagem base64"}}
     */

    private KeyBean key;
    private AnswerBean answer;


    @Override
    public String toString() {
        return "RequestPfFacialCDV{" +
                "key=" + key +
                ", answer=" + answer +
                '}';
    }

    public KeyBean getKey() {
        return key;
    }

    public void setKey(KeyBean key) {
        this.key = key;
    }

    public AnswerBean getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerBean answer) {
        this.answer = answer;
    }
}
