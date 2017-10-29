package com.zetaglobal.expression.evaluator.expressionevaluator.expression;

import java.util.List;

/**
 * @author Sourabh Aggarwal
 */
public class RuleUnit {

    private String leftOperand;
    private Condition condition;
    private List<Object> rightOperand;
    private Type type;

    public RuleUnit() {
    }

    public RuleUnit(String leftOperand, Condition condition, List<Object> rightOperand, Type type) {
        this.leftOperand = leftOperand;
        this.condition = condition;
        this.rightOperand = rightOperand;
        this.type = type;
    }

    public String getLeftOperand() {
        return leftOperand;
    }

    public void setLeftOperand(String leftOperand) {
        this.leftOperand = leftOperand;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public List<Object> getRightOperand() {
        return rightOperand;
    }

    public void setRightOperand(List<Object> rightOperand) {
        this.rightOperand = rightOperand;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return leftOperand + " " + condition + " " + rightOperand;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((condition == null) ? 0 : condition.hashCode());
        result = prime * result + ((leftOperand == null) ? 0 : leftOperand.hashCode());
        result = prime * result + ((rightOperand == null) ? 0 : rightOperand.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        RuleUnit other = (RuleUnit) obj;
        if (condition != other.condition)
            return false;
        if (leftOperand == null) {
            if (other.leftOperand != null)
                return false;
        } else if (!leftOperand.equals(other.leftOperand))
            return false;
        if (rightOperand == null) {
            if (other.rightOperand != null)
                return false;
        } else if (!rightOperand.equals(other.rightOperand))
            return false;
        if (type != other.type)
            return false;
        return true;
    }

    public enum Type {
        FIELD, VALUE
    }
}
