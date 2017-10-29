package com.zetaglobal.expression.evaluator.expressionevaluator.expression;

/**
 * @author Sourabh Aggarwal
 */
public class Rule {

    private RuleUnit leftRuleUnit;
    private LogicGate unitLogicGate;
    private RuleUnit rightRuleUnit;

    private LogicGate ruleLogicGate;
    private Rule ruleNode;

    public Rule() {

    }

    public Rule(RuleUnit leftRuleUnit, LogicGate unitLogicGate, RuleUnit rightRuleUnit) {
        this.leftRuleUnit = leftRuleUnit;
        this.unitLogicGate = unitLogicGate;
        this.rightRuleUnit = rightRuleUnit;
    }

    public RuleUnit getLeftRuleUnit() {
        return leftRuleUnit;
    }

    public void setLeftRuleUnit(RuleUnit leftRuleUnit) {
        this.leftRuleUnit = leftRuleUnit;
    }

    public LogicGate getUnitLogicGate() {
        return unitLogicGate;
    }

    public void setUnitLogicGate(LogicGate unitLogicGate) {
        this.unitLogicGate = unitLogicGate;
    }

    public RuleUnit getRightRuleUnit() {
        return rightRuleUnit;
    }

    public void setRightRuleUnit(RuleUnit rightRuleUnit) {
        this.rightRuleUnit = rightRuleUnit;
    }

    public LogicGate getRuleLogicGate() {
        return ruleLogicGate;
    }

    public void setRuleLogicGate(LogicGate ruleLogicGate) {
        this.ruleLogicGate = ruleLogicGate;
    }

    public Rule getRule() {
        return ruleNode;
    }

    public void setRule(Rule rule) {
        this.ruleNode = rule;
    }

    @Override
    public String toString() {
        return "Rule{"
                +
                "leftRuleUnit=" + leftRuleUnit
                +
                ", unitLogicGate=" + unitLogicGate
                +
                ", rightRuleUnit=" + rightRuleUnit
                +
                ", ruleLogicGate=" + ruleLogicGate
                +
                ", ruleNode=" + ruleNode
                +
                '}';
    }
}
