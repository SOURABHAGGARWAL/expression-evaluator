# expression-evaluator
expression-evaluator



Architecture :

    SOA
    REST

Design Patterns :

    Singleton
    Factory
    Builder

OO Design Principles

    Inheritance
    Encapsulation
    Abstraction

Language :

    Java 8

Framework Used :

    Spring Boot

Build Tool (CI) :

    MAVEN


SERVICE TEST EXAMPLE :

    Import application on eclipse using maven project import.
    After that right clicking on ExpressionEvaluatorApplication.java >> Run As >> Java Application.
    This will start service in embedded tomcat server.
    Now use POST service with below paramters.

URL : http://localhost:8080//validate

Request Body : {"user" : {"age":38}} or any input string.

Output : All the queries saved in queries.txt file will be evaluated on the given input string.



