package com.zetaglobal.expression.evaluator.expressionevaluator.expression;

import com.zetaglobal.expression.evaluator.expressionevaluator.exception.QueryEvaluatorException;

/**
 * @author Sourabh Aggarwal
 */
public class QExpression {

    private Node node;
    private QueryEvaluatorException queryEvaluatorException;

    public QExpression() {

    }

    public QExpression(Node node) {
        setNode(node);
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public QueryEvaluatorException getQueryEvaluatorException() {
        return queryEvaluatorException;
    }

    public void setQueryEvaluatorException(QueryEvaluatorException queryEvaluatorException) {
        this.queryEvaluatorException = queryEvaluatorException;
    }

    @Override
    public String toString() {
        return "LexFilter{" + "node=" + node + '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((node == null) ? 0 : node.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        QExpression other = (QExpression) obj;
        if (node == null) {
            if (other.node != null)
                return false;
        } else if (!node.equals(other.node))
            return false;
        return true;
    }
}