package com.zetaglobal.expression.evaluator.expressionevaluator.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;

import com.zetaglobal.expression.evaluator.expressionevaluator.business.InputValidatorBusiness;
import com.zetaglobal.expression.evaluator.expressionevaluator.exception.QueryEvaluatorException;
import com.zetaglobal.expression.evaluator.expressionevaluator.expression.Node;
import com.zetaglobal.expression.evaluator.expressionevaluator.expression.NodeDataType;
import com.zetaglobal.expression.evaluator.expressionevaluator.expression.QExpression;
import com.zetaglobal.expression.evaluator.expressionevaluator.expression.RuleUnit;
import com.zetaglobal.expression.evaluator.expressionevaluator.repository.QueryRepository;
import com.zetaglobal.expression.evaluator.expressionevaluator.response.QueryResult;

/**
 * @author Sourabh Aggarwal
 */
public class InputValidatorBusinessImpl implements InputValidatorBusiness {

    @Autowired
    JSONParser parser;

    @Autowired
    QueryRepository queryRepository;

    public static void main(String[] args) throws QueryEvaluatorException {
        InputValidatorBusiness inputValidatorBusiness = new InputValidatorBusinessImpl();
        Map<String, QueryResult> data = inputValidatorBusiness.evaluateInput(
                "{\"user\": {\"address\": {\"address_line\": \"XYZ street\",\"city\": \"San Francisco\",\"state\": \"CA\",\"zipcode\": \"94150\"}}}");
        data.forEach((k, v) -> {
            System.out.println(k + " :::::::::::::: " + v);
        });
        System.out.println();
        Map<String, QueryResult> data2 = inputValidatorBusiness.evaluateInput("{\"event\" : {\"category\":\"child\"}}");
        data2.forEach((k, v) -> {
            System.out.println(k + " :::::::::::::: " + v);
        });
        System.out.println();
        Map<String, QueryResult> data3 = inputValidatorBusiness.evaluateInput("{\"user\" : {\"age\":16}}");
        data3.forEach((k, v) -> {
            System.out.println(k + " :::::::::::::: " + v);
        });
    }

    @Override
    public Map<String, QueryResult> evaluateInput(String input) throws QueryEvaluatorException {
        JSONObject inputJson = getValidJson(input);
        Map<String, QueryResult> output = new HashMap<>();
        queryRepository.getQueries().forEach((query, qExpression) -> {
            QueryResult queryResult = new QueryResult();
            if (null != qExpression && null == qExpression.getQueryEvaluatorException()) {
                try {
                    queryResult.setQueryEvaluatorException(null);
                    queryResult.setResponse(evaluateLexQuery(qExpression, inputJson));
                } catch (Exception e) {
                    queryResult.setQueryEvaluatorException(new QueryEvaluatorException(e.getMessage()));
                    queryResult.setResponse(false);
                }
            } else if (null != qExpression) {
                queryResult.setQueryEvaluatorException(qExpression.getQueryEvaluatorException());
                queryResult.setResponse(false);
            } else {
                queryResult.setQueryEvaluatorException(new QueryEvaluatorException("Empty or null query!!!!."));
                queryResult.setResponse(false);
            }
            output.put(query, queryResult);
        });
        return output;
    }

    /**
     * Evaluate the input with QExpression query.
     *
     * @param lexFilter
     * @param inputJson
     * @return
     * @throws QueryEvaluatorException
     */
    private Boolean evaluateLexQuery(QExpression lexFilter, JSONObject inputJson) throws QueryEvaluatorException {
        if (lexFilter.getNode().getNodeData().getType().equals(NodeDataType.RULE_UNIT)) {
            return evaluateRuleUnit(lexFilter.getNode().getNodeData().getRuleUnit(), inputJson);
        } else if (lexFilter.getNode().getNodeData().getType().equals(NodeDataType.LOGIC_GATE)) {
            List<Boolean> ruleUnitResults = new ArrayList<>();
            for (Node innerNode : lexFilter.getNode().getNodes()) {
                ruleUnitResults.add(evaluateRuleUnit(innerNode.getNodeData().getRuleUnit(), inputJson));
            }
            return lexFilter.getNode().getNodeData().getLogicGate().operate(ruleUnitResults);
        } else {
            throw new QueryEvaluatorException("Query type not supported as of now.");
        }
    }

    /**
     * Method to get the rule unit result.
     *
     * @param ruleUnit
     * @param inputJson
     * @return
     */
    private Boolean evaluateRuleUnit(RuleUnit ruleUnit, JSONObject inputJson) {
        if (ruleUnit.getType().equals(RuleUnit.Type.FIELD)) {
            Object object = checkAndGetQueryField(inputJson, ruleUnit.getLeftOperand());
            if (null != object) {
                return ruleUnit.getCondition().operate(object, ruleUnit.getRightOperand());
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * Checking for the field name in json input.
     *
     * @param inputJson
     * @param ruleUnit
     * @return
     */
    private Object checkAndGetQueryField(JSONObject inputJson, String operand) {
        String[] fieldArray = operand.split("\\.");
        int i = 0;
        JSONObject processingJson = inputJson;
        while (i < fieldArray.length) {
            if (processingJson.containsKey(fieldArray[i])) {
                Object object = processingJson.get(fieldArray[i]);
                if (object instanceof JSONObject) {
                    processingJson = (JSONObject) processingJson.get(fieldArray[i]);
                } else {
                    return object;
                }
            } else {
                return null;
            }
            i = i + 1;
        }
        return processingJson;
    }

    /**
     * Validate and return the jsonobject for input string.
     * 
     * @param input
     * @return
     * @throws QueryEvaluatorException
     */
    private JSONObject getValidJson(String input) throws QueryEvaluatorException {
        JSONObject jsonObject = null;
        try {
            Object obj = parser.parse(input);
            jsonObject = (JSONObject) obj;
        } catch (Exception pe) {
            throw new QueryEvaluatorException(pe.getMessage());
        }
        return jsonObject;
    }
}
