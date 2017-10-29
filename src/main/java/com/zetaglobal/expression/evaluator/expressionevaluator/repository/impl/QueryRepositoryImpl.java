package com.zetaglobal.expression.evaluator.expressionevaluator.repository.impl;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.zetaglobal.expression.evaluator.expressionevaluator.exception.QueryEvaluatorException;
import com.zetaglobal.expression.evaluator.expressionevaluator.expression.QExpression;
import com.zetaglobal.expression.evaluator.expressionevaluator.repository.QueryRepository;
import com.zetaglobal.expression.evaluator.expressionevaluator.util.QueryToQExpressionConverter;

/**
 * @author Sourabh Aggarwal
 */
public class QueryRepositoryImpl implements QueryRepository {

    private static final String STATIC_QUERIES_TXT = "static/queries.txt";

    @Autowired
    QueryToQExpressionConverter queryToLexConverter;

    public Map<String, QExpression> getQueries() throws QueryEvaluatorException {
        Map<String, QExpression> lexFilters = new LinkedHashMap<>();
        getFile(STATIC_QUERIES_TXT).forEach(query -> {
            lexFilters.put(query, queryToLexConverter.convertQueryToQExpression(query));
        });
        return lexFilters;
    }

    /**
     * Getting all the queries from the files.
     *
     * @param fileName
     * @return
     * @throws QueryEvaluatorException
     */
    private List<String> getFile(String fileName) throws QueryEvaluatorException {
        List<String> queries = new LinkedList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                queries.add(line);
            }
            scanner.close();
        } catch (IOException e) {
            throw new QueryEvaluatorException("Error while reading the queries from the file.");
        }
        return queries;
    }

}
