package com.zetaglobal.expression.evaluator.expressionevaluator;

import org.json.simple.parser.JSONParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.zetaglobal.expression.evaluator.expressionevaluator.business.InputValidatorBusiness;
import com.zetaglobal.expression.evaluator.expressionevaluator.business.impl.InputValidatorBusinessImpl;
import com.zetaglobal.expression.evaluator.expressionevaluator.repository.QueryRepository;
import com.zetaglobal.expression.evaluator.expressionevaluator.repository.impl.QueryRepositoryImpl;
import com.zetaglobal.expression.evaluator.expressionevaluator.service.InputValidatorService;
import com.zetaglobal.expression.evaluator.expressionevaluator.service.impl.InputValidatorServiceImpl;
import com.zetaglobal.expression.evaluator.expressionevaluator.util.QueryToQExpressionConverter;

@SpringBootApplication
public class ExpressionEvaluatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpressionEvaluatorApplication.class, args);
    }

    @Bean
    public JSONParser jsonParser() {
        return new JSONParser();
    }

    @Bean
    public InputValidatorService inputValidatorService() {
        return new InputValidatorServiceImpl();
    }

    @Bean
    public InputValidatorBusiness inputValidatorBusiness() {
        return new InputValidatorBusinessImpl();
    }

    @Bean
    public QueryRepository queryRepository() {
        return new QueryRepositoryImpl();
    }

    public QueryToQExpressionConverter queryToQExpressionConverter() {
        return new QueryToQExpressionConverter();
    }

}
