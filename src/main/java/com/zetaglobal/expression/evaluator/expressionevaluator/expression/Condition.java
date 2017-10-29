package com.zetaglobal.expression.evaluator.expressionevaluator.expression;

import java.util.List;

/**
 * @author Sourabh Aggarwal
 */
public enum Condition {

    EQ("==") {
        @Override
        public Boolean operate(Object value1, Object value2) {
            List<?> list = (List<?>) value2;
            if (value1 instanceof String) {
                return value1.equals(list.get(0));
            } else {
                return value1 == list.get(0);
            }
        }
    },
    GT(">") {
        @Override
        public Boolean operate(Object value1, Object value2) {
            List<?> list = (List<?>) value2;
            Number number1 = (Number) value1;
            Number number2 = (Number) list.get(0);
            return number1.doubleValue() > number2.doubleValue();
        }
    },
    IN(" in") {
        @Override
        public Boolean operate(Object value1, Object value2) {
            List<?> list = (List<?>) value2;
            return list.contains(value1);
        }
    },
    LT("<") {
        @Override
        public Boolean operate(Object value1, Object value2) {
            List<?> list = (List<?>) value2;
            Number number1 = (Number) value1;
            Number number2 = (Number) list.get(0);
            return number1.doubleValue() < number2.doubleValue();
        }
    },
    EXCLUSION_LIST(" exclude") {
        @Override
        public Boolean operate(Object value1, Object value2) {
            List<?> list = (List<?>) value2;
            return !list.contains(value1);
        }
    },
    NOT_BETWEEN(" !between") {
        @Override
        public Boolean operate(Object value1, Object value2) {
            List<Number> list = (List) value2;
            Number number = (Number) value1;
            return number.doubleValue() < list.get(0).doubleValue() || number.doubleValue() > list.get(1).doubleValue();
        }
    },
    BETWEEN(" between") {
        @Override
        public Boolean operate(Object value1, Object value2) {
            List<Number> list = (List) value2;
            Number number = (Number) value1;
            return number.doubleValue() >= list.get(0).doubleValue() && number.doubleValue() <= list.get(1).doubleValue();
        }
    },
    DOESNT_STARTS_WITH(" !startswith") {
        @Override
        public Boolean operate(Object value1, Object value2) {
            List<?> list = (List<?>) value2;
            return !value1.toString().startsWith(list.get(0).toString());
        }
    },
    STARTS_WITH(" startswith") {
        @Override
        public Boolean operate(Object value1, Object value2) {
            List<?> list = (List<?>) value2;
            return value1.toString().startsWith(list.get(0).toString());
        }
    },
    DOESNT_ENDS_WITH(" !endswith") {
        @Override
        public Boolean operate(Object value1, Object value2) {
            List<?> list = (List<?>) value2;
            return !value1.toString().endsWith(list.get(0).toString());
        }
    },
    ENDS_WITH(" endswith") {
        @Override
        public Boolean operate(Object value1, Object value2) {
            List<?> list = (List<?>) value2;
            return value1.toString().endsWith(list.get(0).toString());
        }
    },
    DOESNT_CONTAINS(" !contain") {
        @Override
        public Boolean operate(Object value1, Object value2) {
            List<?> list = (List<?>) value2;
            return !value1.toString().contains(list.get(0).toString());
        }
    },
    CONTAINS(" contain") {
        @Override
        public Boolean operate(Object value1, Object value2) {
            List<?> list = (List<?>) value2;
            return value1.toString().contains(list.get(0).toString());
        }
    },
    NOT_EQUALS("!=") {
        @Override
        public Boolean operate(Object value1, Object value2) {
            List<?> list = (List<?>) value2;
            return value1 != list.get(0);
        }
    },
    GREATER_THAN_OR_EQUALS(">=") {
        @Override
        public Boolean operate(Object value1, Object value2) {
            List<?> list = (List<?>) value2;
            Number number1 = (Number) value1;
            Number number2 = (Number) list.get(0);
            return number1.doubleValue() >= number2.doubleValue();
        }
    },
    LESSER_THAN_OR_EQUALS("<=") {
        @Override
        public Boolean operate(Object value1, Object value2) {
            List<?> list = (List<?>) value2;
            Number number1 = (Number) value1;
            Number number2 = (Number) list.get(0);
            return number1.doubleValue() <= number2.doubleValue();
        }
    };

    private String value;

    Condition(String value) {
        this.value = value;
    }

    public static Condition getValue(String key) {
        if (key == null || key.trim().isEmpty()) {
            return null;
        }
        try {
            return valueOf(key.trim());
        } catch (Exception e) {
            for (Condition condition : values()) {
                if (condition.value.trim().equals(key.trim())) {
                    return condition;
                }
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public abstract Boolean operate(Object value1, Object value2);
}
