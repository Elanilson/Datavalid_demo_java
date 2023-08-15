package com.apkdoandroid.datavalid_demo.model;

public class StatusResposta {

    /**
     * code : 900902
     * message : Missing Credentials
     * description : Invalid Credentials. Make sure your API invocation call has a header: 'null : Bearer ACCESS_TOKEN' or 'null : Basic ACCESS_TOKEN' or 'apikey: API_KEY'
     */

    private String code;
    private String message;
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
