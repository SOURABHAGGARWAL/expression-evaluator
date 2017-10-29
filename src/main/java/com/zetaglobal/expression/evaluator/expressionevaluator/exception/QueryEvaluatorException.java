package com.zetaglobal.expression.evaluator.expressionevaluator.exception;

/**
 * @author Sourabh Aggarwal
 */
public class QueryEvaluatorException extends Exception {
    private static final long serialVersionUID = 1997753363232807009L;

    public QueryEvaluatorException() {
    }

    public QueryEvaluatorException(String message) {
        super(message);
    }

    public QueryEvaluatorException(Throwable cause) {
        super(cause);
    }

    public QueryEvaluatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public QueryEvaluatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
