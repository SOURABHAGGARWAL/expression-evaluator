package com.zetaglobal.expression.evaluator.expressionevaluator.expression;

/**
 * @author Sourabh Aggarwal.
 */
public class NodeData {

    private RuleUnit ruleUnit;

    private LogicGate logicGate;

    private NodeDataType type;

    public NodeData() {
    }

    public NodeData(RuleUnit ruleUnit) {
        this.ruleUnit = ruleUnit;
        this.type = NodeDataType.RULE_UNIT;
    }

    public NodeData(LogicGate logicGate) {
        this.logicGate = logicGate;
        this.type = NodeDataType.LOGIC_GATE;
    }

    public RuleUnit getRuleUnit() {
        return ruleUnit;
    }

    public void setRuleUnit(RuleUnit ruleUnit) {
        this.ruleUnit = ruleUnit;
    }

    public LogicGate getLogicGate() {
        return logicGate;
    }

    public void setLogicGate(LogicGate logicGate) {
        this.logicGate = logicGate;
    }

    public NodeDataType getType() {
        return type;
    }

    public void setType(NodeDataType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ruleUnit=" + ruleUnit
                +
                ", logicGate=" + logicGate
                +
                ", type=" + type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((logicGate == null) ? 0 : logicGate.hashCode());
        result = prime * result + ((ruleUnit == null) ? 0 : ruleUnit.hashCode());
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
        NodeData other = (NodeData) obj;
        if (logicGate != other.logicGate)
            return false;
        if (ruleUnit == null) {
            if (other.ruleUnit != null)
                return false;
        } else if (!ruleUnit.equals(other.ruleUnit))
            return false;
        if (type != other.type)
            return false;
        return true;
    }
}
