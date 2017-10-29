package com.zetaglobal.expression.evaluator.expressionevaluator.response;

import java.io.Serializable;

import com.zetaglobal.expression.evaluator.expressionevaluator.exception.QueryEvaluatorException;

/**
 * @author Sourabh Aggarwal
 */
public class QueryResult implements Serializable {
    private static final long serialVersionUID = -1303007013385371247L;
    private Boolean response;
    private QueryEvaluatorException queryEvaluatorException;

    public Boolean getResponse() {
        return response;
    }

    public void setResponse(Boolean response) {
        this.response = response;
    }

    public QueryEvaluatorException getQueryEvaluatorException() {
        return queryEvaluatorException;
    }

    public void setQueryEvaluatorException(QueryEvaluatorException queryEvaluatorException) {
        this.queryEvaluatorException = queryEvaluatorException;
    }

    @Override
    public String toString() {
        return "QueryResult [response=" + response + ", queryEvaluatorException=" + queryEvaluatorException + "]";
    }
}
