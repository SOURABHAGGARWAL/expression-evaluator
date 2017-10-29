package com.zetaglobal.expression.evaluator.expressionevaluator.response;

/**
 * @author Sourabh Aggarwal
 */
public enum ResponseCode {
    FAIL(400, "Query Evaluator service failed."), 
    SUCCESS(200, "Query Evaluator service success."), 
    INTERNAL_SERVER_ERROR(500, "Query Evaluator service internal server error.");

    private int code;
    private String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
