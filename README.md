# QuizFlow API

A RESTful backend service built to manage question banks and evaluate dynamic quizzes. The project implements a clean, layered architecture and standard API design patterns.

## Features

* **Question Management:** Endpoints to add and retrieve questions, filterable by category.
* **Quiz Generation:** Creates customized quiz sessions by pulling random questions from the database based on category and desired length.
* **Secure Payloads:** Implements the DTO pattern (`QuestionWrapper`) to hide correct answers from the client during an active quiz session.
* **Score Calculation:** Server-side evaluation of user submissions.
* **Error Handling:** Standardized API error responses via global exception handlers (`@RestControllerAdvice`).

## Tech Stack

* Java 17
* Spring Boot (Web, Data JPA)
* PostgreSQL
* Lombok

## Local Setup

1. Clone the repository.
2. Create a PostgreSQL database named `questiondb`.
3. Update your database credentials in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/questiondb
   spring.datasource.username=your_username
   spring.datasource.password=your_password
