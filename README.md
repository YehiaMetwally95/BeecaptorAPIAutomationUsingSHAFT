## Overview
- Test Automation Project for Beecaptor APIs with RestAssured written by Java and based on Maven
- Using SHAFT Engine as Automation Framework
- Using TestNG as the Testing Framework
- Used Design Patterns:
    - Using Fluent Page Object Model Design Pattern in writing UI Test script and Page actions, thus chaining the Scenario steps and validations in one line of code
    - Using Fluent Object Model Design Pattern in writing API Test scripts, thus chaining the Scenario steps and validations in one line of code
    - Using Object Model Design by setting two Object Model Classes for Request and Response of every Endpoint such that:
        - Request Object Model Class that contains all methods performed on Request Parameters through Request Pojo Class, includes Preparing Request body with static or dynamic data and Executing the Request
        - Response Object Model Class that contains all Validations and Getters performed on the Response Parameters through Response Pojo Class
    - Using Pojo Classes for storing all Request and Response Parameters for every Endpoint with the help of Jackson Library for deserializing Json Payloads into Pojo Classes
    - Using Advanced JsonPath Expressions to Filter data from Response and to get data relevant to another data 
    - Using Lombok Library for generating Setters, Getters & Constructors & ToString of All Pojo Classes, thus reduce Boiler plate Code
    - Builder Pattern for Constructing Request Pojo Class with input parameters step by step in fluent manner to build the Request Body

- Test Data Management such that store All Test data in Json File for each Test Class
- Using TestNG XML File to Trigger Tests Locally
- Performing Test Execution Remotely from CI/CD Pipeline with GitHub Actions

## Application Under Test
-  https://beeceptor.com/docs/sample-api-for-testing/

