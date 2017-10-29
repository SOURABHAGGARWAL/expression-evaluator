package com.zetaglobal.expression.evaluator.expressionevaluator.repository;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zetaglobal.expression.evaluator.expressionevaluator.exception.QueryEvaluatorException;
import com.zetaglobal.expression.evaluator.expressionevaluator.expression.QExpression;

@Repository
public interface QueryRepository {
    /**
     * Method to get all the queries from the file.
     *
     * @return
     * @throws QueryEvaluatorException
     */
    Map<String, QExpression> getQueries() throws QueryEvaluatorException;
}
