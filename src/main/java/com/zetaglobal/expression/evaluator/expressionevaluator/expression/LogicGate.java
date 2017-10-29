package com.zetaglobal.expression.evaluator.expressionevaluator.expression;

import java.util.List;

/**
 * @author Sourabh Aggarwal
 */
public enum LogicGate {
    AND("AND") {
        @Override
        public Boolean operate(List<Boolean> operates) {
            Boolean result = operates.get(0);
            for (int i = 1; i < operates.size(); i++) {
                result = result && operates.get(i);
            }
            return result;
        }
    },
    OR("OR") {
        @Override
        public Boolean operate(List<Boolean> operates) {
            Boolean result = operates.get(0);
            for (int i = 1; i < operates.size(); i++) {
                result = result || operates.get(i);
            }
            return result;
        }
    },
    NOR("NOR") {
        @Override
        public Boolean operate(List<Boolean> operates) {
            Boolean result = operates.get(0);
            for (int i = 1; i < operates.size(); i++) {
                result = result || operates.get(i);
            }
            return !result;
        }
    },
    NAND("NAND") {
        @Override
        public Boolean operate(List<Boolean> operates) {
            Boolean result = operates.get(0);
            for (int i = 1; i < operates.size(); i++) {
                result = result && operates.get(i);
            }
            return !result;
        }
    };

    private String value;

    LogicGate(String value) {
        this.value = value;
    }

    public static LogicGate getValue(String key) {
        if (key == null || key.trim().isEmpty()) {
            return null;
        }

        try {
            return valueOf(key.trim());
        } catch (Exception e) {
            for (LogicGate logicGate : values()) {
                if (logicGate.value.trim().equals(key.trim())) {
                    return logicGate;
                }
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public abstract Boolean operate(List<Boolean> operates);
}
