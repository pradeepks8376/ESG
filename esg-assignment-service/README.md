# CSV to REST API Java Application

## Project Setup

1. Clone the repository
2. Navigate to the project directory
3. Run `mvn clean install` to build the project

## Running the Application

- Ensure you have a CSV file at the specified path in `Application.java`
- Run the application using your IDE or `mvn spring-boot:run`

## REST API Endpoints

- POST `/api/customers` to add a customer
- GET `/api/customers/{customerRef}` to retrieve customer by reference

## TDD Approach

- Tests are located in the `src/test` directory
- Tests cover CSV reading, API communication, and database integration

## Dependencies

- Spring Boot
- OpenCSV
- Jackson
- H2 Database
