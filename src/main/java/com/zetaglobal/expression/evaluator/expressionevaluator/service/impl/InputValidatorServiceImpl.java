package com.zetaglobal.expression.evaluator.expressionevaluator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.zetaglobal.expression.evaluator.expressionevaluator.business.InputValidatorBusiness;
import com.zetaglobal.expression.evaluator.expressionevaluator.exception.QueryEvaluatorException;
import com.zetaglobal.expression.evaluator.expressionevaluator.response.QueryEvaluatorResponse;
import com.zetaglobal.expression.evaluator.expressionevaluator.response.ResponseCode;
import com.zetaglobal.expression.evaluator.expressionevaluator.service.InputValidatorService;

/**
 * @author Sourabh Aggarwal
 */
public class InputValidatorServiceImpl implements InputValidatorService {

    @Autowired
    InputValidatorBusiness inputValidatorBusiness;

    @Override
    public QueryEvaluatorResponse evaluateInput(String input) {
        try {
            QueryEvaluatorResponse queryEvaluatorResponse = new QueryEvaluatorResponse();
            queryEvaluatorResponse.setResponseCode(ResponseCode.SUCCESS.getCode());
            queryEvaluatorResponse.setResponseMessage(ResponseCode.SUCCESS.getMessage());
            queryEvaluatorResponse.setResponse(inputValidatorBusiness.evaluateInput(input));
            return queryEvaluatorResponse;
        } catch (QueryEvaluatorException qee) {
            QueryEvaluatorResponse queryEvaluatorResponse = new QueryEvaluatorResponse();
            queryEvaluatorResponse.setResponseCode(ResponseCode.FAIL.getCode());
            queryEvaluatorResponse.setResponseMessage(ResponseCode.FAIL.getMessage());
            queryEvaluatorResponse.setResponse(false);
            return queryEvaluatorResponse;
        }
    }
}
