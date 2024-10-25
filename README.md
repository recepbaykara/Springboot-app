# User Management Application

This project is a user management application developed using Spring Boot, PostgreSQL, and HTML (JavaScript). The application performs basic CRUD (Create, Read, Update, Delete) operations to manage user information (id, name, email, date of birth, and age). The user's age is automatically updated based on their date of birth. The application runs on Kubernetes and is containerized using Docker.

## Features

- Add, view, update, and delete user information.
- Age is automatically calculated from the date of birth.
- Application runs in a Kubernetes environment.
- Application is distributed via Docker containers.

## Technologies

- **Spring Boot**: Used for backend development.
- **PostgreSQL**: Used for database management.
- **HTML / JavaScript**: Used for frontend development.
- **Docker**: Used for containerizing the application.
- **Kubernetes**: Used for managing and deploying the application.

## Installation

### Requirements

- Java 11 or higher
- Docker
- Kubernetes

### Running the Project

1. **Build the Docker Image**:
   ```bash
   docker build -t user-management-app .
