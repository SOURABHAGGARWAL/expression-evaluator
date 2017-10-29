package com.zetaglobal.expression.evaluator.expressionevaluator.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zetaglobal.expression.evaluator.expressionevaluator.response.QueryEvaluatorResponse;

/**
 * @author Sourabh Aggarwal
 */
@Service
public interface InputValidatorService {
    /**
     * Validate the input from the user
     *
     * @param input
     *            containing the input from the user
     */
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    QueryEvaluatorResponse evaluateInput(@RequestBody String input);
}
