package com.zetaglobal.expression.evaluator.expressionevaluator.util;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zetaglobal.expression.evaluator.expressionevaluator.exception.QueryEvaluatorException;
import com.zetaglobal.expression.evaluator.expressionevaluator.expression.Condition;
import com.zetaglobal.expression.evaluator.expressionevaluator.expression.LogicGate;
import com.zetaglobal.expression.evaluator.expressionevaluator.expression.Node;
import com.zetaglobal.expression.evaluator.expressionevaluator.expression.NodeData;
import com.zetaglobal.expression.evaluator.expressionevaluator.expression.QExpression;
import com.zetaglobal.expression.evaluator.expressionevaluator.expression.RuleUnit;
import com.zetaglobal.expression.evaluator.expressionevaluator.expression.RuleUnit.Type;

@Component
public class QueryToQExpressionConverter {

    @Autowired
    JSONParser parser;

    /**
     * Getting lexFilter for the queries.
     * 
     * @param query
     * @return
     * @throws QueryEvaluatorException
     */
    public QExpression convertQueryToQExpression(String query) {
        QExpression qExpression = new QExpression();
        try {
            JSONArray jsonArray = convertToJsonArray(query);
            if (jsonArray.get(1) instanceof JSONArray) {
                List<Node> nodeList = getListOfNodes(jsonArray);
                if (!nodeList.isEmpty()) {
                    NodeData nodeDataLogical = new NodeData(LogicGate.valueOf(jsonArray.get(0).toString()));
                    Node node = new Node(nodeDataLogical, getListOfNodes(jsonArray));
                    qExpression.setNode(node);
                    return qExpression;
                } else {
                    qExpression.setQueryEvaluatorException(new QueryEvaluatorException("Nothing to compare in query."));
                }
            } else if (jsonArray.get(1) instanceof String) {
                NodeData nodeData = new NodeData(getRuleUnit(jsonArray));
                Node node = new Node(nodeData, null);
                qExpression.setNode(node);
                return qExpression;
            } else {
                qExpression.setQueryEvaluatorException(new QueryEvaluatorException("Empty query experssion."));
            }
        } catch (Exception queryEvaluatorException) {
            qExpression.setQueryEvaluatorException(new QueryEvaluatorException("Exception in converting query to lexfilter"));
        }
        return qExpression;
    }

    /**
     * Method used to get the list of nodes.
     * 
     * @param jsonArray
     * @return
     * @throws QueryEvaluatorException
     */
    private List<Node> getListOfNodes(JSONArray jsonArray) throws QueryEvaluatorException {
        List<Node> nodes = new ArrayList<>();
        for (int i = 1; i < jsonArray.size(); i++) {
            JSONArray jsonArrayElement = convertToJsonArray(jsonArray.get(i).toString());
            RuleUnit ruleUnit = getRuleUnit(jsonArrayElement);
            NodeData nodeData = new NodeData(ruleUnit);
            Node node = new Node(nodeData, null);
            nodes.add(node);
        }
        return nodes;
    }

    /**
     * Method used to get the RuleUnit From String.
     * 
     * @param jsonArrayElement
     * @return
     */
    @SuppressWarnings("unchecked")
    private RuleUnit getRuleUnit(JSONArray jsonArrayElement) {
        String operator = jsonArrayElement.get(0).toString();
        String operand = jsonArrayElement.get(1).toString();
        Object value = jsonArrayElement.get(2);
        List<Object> valueObjects = new ArrayList<>();
        if (value instanceof JSONArray) {
            JSONArray arrayValue = (JSONArray) value;
            arrayValue.forEach(valuesInArray -> valueObjects.add(valuesInArray));
        } else {
            valueObjects.add(value);
        }
        return new RuleUnit(operand, Condition.valueOf(operator), valueObjects, Type.FIELD);
    }

    /**
     * Convert string to json array format.
     * 
     * @param input
     * @return
     * @throws QueryEvaluatorException
     */
    private JSONArray convertToJsonArray(String input) throws QueryEvaluatorException {
        JSONArray jsonArray = null;
        try {
            Object obj = parser.parse(input);
            jsonArray = (JSONArray) obj;
        } catch (ParseException pe) {
            throw new QueryEvaluatorException();
        }
        return jsonArray;
    }
}
