# Task Manager API (Spring Boot)

---
## 📌 Overview
Task Manager API is a RESTful web service built with Spring Boot that allows you to manage tasks efficiently.

It supports full CRUD operations and uses an in-memory H2 database for data storage.

---
## Tech Stack
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
---
## Features
- Create a task
- Get all tasks
- Get task by ID
- Update task
- Delete task
- Support for task tags
- Async task creation (ExecutorService)

---
## 🏗 Project Structure

src/main/java/task_manager_api/demo

├── controller # REST controllers

├── service # Business logic

├── repository # Data access layer

├── model # Entities

├── exception # Custom exceptions & handlers

---

## Getting Started!

### 1. Clone the repository
```bash
git clone https://github.com/YOUR_USERNAME/task-manager-api.git
cd task-manager-api
```
### 2. Run the application 
```bash
./mvnw spring-boot:run
```
### 3. Open in browser
http://localhost:8080/tasks

### API Endpoints
* Get all tasks (GET /tasks)
* Create a task (POST /tasks)

Request body:
  {
  "name": "Learn Spring",
  "priority": 5
  }
* Get task by ID (GET /tasks/{id})
* Update task (PUT /tasks/{id})

Request body:
{
"name": "Updated task",
"priority": 3
}

* Delete task (DELETE /tasks/{id})

---

### H2 Database Console

You can access the database UI:

http://localhost:8080/h2-console

### Connection settings:

JDBC URL: jdbc:h2:mem:testdb

User: sa

Password: (empty)

---
### Notes
IDs are auto-generated and not reused after deletion (expected behavior)
Integer is used instead of int to avoid JSON deserialization issues with null values

# Author: Oleksander Marynenko

# If you like this project: Give it a star ⭐ on GitHub! :D