# NotificationBackend

**NotificationBackend** is a Java-based backend application built with Spring Boot, designed for managing and sending notifications. The project is structured as a WAR file and uses an in-memory H2 database for development.

# Table of Contents

- [Requirements](#requirements)
- [Project Structure](#project-structure)
- [Dependencies](#dependencies)
- [Running the Application](#running-the-application)
    - [Build the Project](#build-the-project)
    - [Run the Application](#run-the-application)
- [Running Tests](#running-tests)

## Requirements
To develop and run this project, ensure that you have the following installed:

- IDE: IntelliJ IDEA 2023.1.2
- Java JDK: OpenJDK 21.0.2
- Dependency manager: Maven 3.9.7

## Project Structure

The project directory structure is organized as follows:

```plaintext
├── src
├──├── main
├──├──├── java
├──├──├──├── br.com.devinvestidor.notification
├──├──├──├──├── config
├──├──├──├──├── controller
├──├──├──├──├── dao
├──├──├──├──├── dto
├──├──├──├──├── entity
├──├──├──├──├── exception
├──├──├──├──├── response
├──├──├──├──├── service
├──├──├──├──├── NotificationBackendApplication.java
├──├──├──├──├── ServletInitializer.java
├──├──├── resources
├──├── test
├──├──├── java
├──├──├──├── br.com.devinvestidor.notification
├──├──├──├──├── services
├── target
├── pom.xml
├── README.md
```

## Dependencies

The project uses Maven and includes the following dependencies in the `pom.xml`:

- **Spring Boot Starter Data JPA**: Provides support for JPA and database operations.
- **Spring Boot Starter Web**: Facilitates building web applications and RESTful APIs.
- **Spring Boot DevTools**: Enhances development with additional tools and automatic restarts.
- **H2 Database**: An in-memory database used for development and testing.
- **Lombok**: A library that reduces boilerplate code.
- **Spring Boot Starter Tomcat**: Provides Tomcat as the default servlet container for deployment.
- **Commons Lang**: Provides additional utilities for Java.
- **Spring Boot Starter Test**: Includes libraries for testing.


## Running the Application
To build and run the application, use the following commands:

### Build the Project:
`mvn clean install`

### Run the Application:
`mvn spring-boot:run`
The application will be available at http://localhost:8080.

## Running Tests
To run the unit tests, use:
`mvn test`