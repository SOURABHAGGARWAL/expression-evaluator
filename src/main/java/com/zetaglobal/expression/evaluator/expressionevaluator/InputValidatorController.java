package com.zetaglobal.expression.evaluator.expressionevaluator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zetaglobal.expression.evaluator.expressionevaluator.response.QueryEvaluatorResponse;
import com.zetaglobal.expression.evaluator.expressionevaluator.service.InputValidatorService;

@RestController
public class InputValidatorController {
    @Autowired
    InputValidatorService inputValidatorService;

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    QueryEvaluatorResponse evaluateInput(@RequestBody String input) {
        return inputValidatorService.evaluateInput(input);
    }
}
