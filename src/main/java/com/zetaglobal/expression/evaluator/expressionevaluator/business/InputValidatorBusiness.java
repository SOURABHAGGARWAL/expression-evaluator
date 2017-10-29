package com.zetaglobal.expression.evaluator.expressionevaluator.business;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.zetaglobal.expression.evaluator.expressionevaluator.exception.QueryEvaluatorException;
import com.zetaglobal.expression.evaluator.expressionevaluator.response.QueryResult;

@Service
public interface InputValidatorBusiness {
    /**
     * Validate the input from the user
     *
     * @param input
     *            containing the input from the user
     * @throws QueryEvaluatorException
     */
    Map<String, QueryResult> evaluateInput(@RequestBody String input) throws QueryEvaluatorException;
}
