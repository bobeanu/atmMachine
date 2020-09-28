# ATM Machine REST API

Atm machine REST API is a spring boot application that exposes 2 endpoints(inquiry, withdraw). The 4 initial created user accounts are kept in H2 database memory.

## Requirements

- JDK 11
- Maven

## Running the application locally

You can run the application by executing the `main` method in the `com.test.atm.AtmApplication` class from your IDE.


The application starts on port 9090 and it exposes 2 endpoints:

- http://localhost:9090/rest/atm/inquiry?userId=1

- http://localhost:9090/rest/atm/withdraw?userId=1&amount=50

## Running tests

You can run the tests in class `AccountRepositoryIntegrationServiceTest` from your IDE.
