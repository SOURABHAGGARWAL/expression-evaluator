package com.zetaglobal.expression.evaluator.expressionevaluator.response;

import java.io.Serializable;

/**
 * @author Sourabh Aggarwal
 */
public class QueryEvaluatorResponse implements Serializable {
    private static final long serialVersionUID = -3315957980610592489L;
    private Class<?> reponseClass;
    private int responseCode;
    private String responseMessage;
    private Object response;
    public Class<?> getReponseClass() {
        return reponseClass;
    }
    public void setReponseClass(Class<?> reponseClass) {
        this.reponseClass = reponseClass;
    }
    public int getResponseCode() {
        return responseCode;
    }
    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
    public String getResponseMessage() {
        return responseMessage;
    }
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
    public Object getResponse() {
        return response;
    }
    public void setResponse(Object response) {
        this.response = response;
    }
}
