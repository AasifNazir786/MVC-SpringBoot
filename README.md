# MVC-SpringBoot
# MVC-Spring Boot Project

This is a **Spring Boot MVC web application** that allows users to manage projects and their associated tasks. The project demonstrates complete CRUD operations (Create, Read, Update, Delete) for both Projects and Tasks.

## Features

- **Add New Projects**: Create new projects and associate multiple tasks with them.
- **View Projects**: List all projects with their tasks.
- **Edit Projects**: Modify existing projects and update associated tasks.
- **Delete Projects**: Remove a project and its associated tasks.
- **CRUD for Tasks**: Manage tasks associated with projects (add, update, delete).
- **Responsive UI**: The frontend is styled with basic CSS for simplicity and responsiveness.

## Technologies Used

- **Spring Boot**: Provides the framework to build a robust MVC application.
- **Spring Data JPA**: Used for database interaction and ORM mapping.
- **Lombok**: Reduces boilerplate code for models (e.g., getters, setters).
- **Thymeleaf**: Template engine for rendering views.
- **PostgreSQL**: Database for persisting project and task data.
- **Spring Boot DevTools**: Hot-reloading during development for faster feedback.

## Project Structure

```bash
src/
├── main/
│   ├── java/
│   │   └── com/example/MVC_SpringBoot/
│   │       ├── controller/
│   │       │   └── ProjectController.java  # Handles HTTP requests for Projects and Tasks
│   │       ├── model/
│   │       │   ├── Project.java  # Represents Project entity with Lombok annotations
│   │       │   └── Task.java     # Represents Task entity with Lombok annotations
│   │       ├── repository/
│   │       │   └── ProjectRepository.java  # Repository for Project entity
│   │       ├── service/
│   │       │   └── ProjectService.java     # Business logic for managing Projects and Tasks
│   ├── resources/
│   │   ├── templates/
│   │   │   └── projects.html  # Thymeleaf templates for project and task views
│   │   └── application.properties  # Database configuration
│
└── pom.xml  # Maven dependencies
```

## Getting Started

### Prerequisites

Make sure you have the following installed:

- **Java 17+**: Required for Spring Boot 3.0+.
- **Maven**: For building and running the project.
- **PostgreSQL**: Database system used in this project.

### Installation and Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/MVC-SpringBoot.git
   cd MVC-SpringBoot
   ```

2. Configure PostgreSQL in `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_db_name
   spring.datasource.username=your_db_username
   spring.datasource.password=your_db_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Build and run the project using Maven:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. Access the application by navigating to [http://localhost:8080/projects](http://localhost:8080/projects) in your browser.

### Database Configuration

Make sure to create a PostgreSQL database and user:

```sql
CREATE DATABASE your_db_name;
CREATE USER your_db_username WITH PASSWORD 'your_db_password';
GRANT ALL PRIVILEGES ON DATABASE your_db_name TO your_db_username;
```

### CRUD Operations

1. **Create a Project with Tasks**: Go to `/projects/new` to create a new project and add tasks (comma-separated).
2. **View Projects**: View the list of all projects and their tasks on `/projects`.
3. **Edit Projects**: Go to `/projects/edit/{id}` to edit the project details and associated tasks.
4. **Delete Projects**: Go to `/projects/delete/{id}` to delete a project and all its associated tasks.
5. **Manage Tasks**: Tasks can be added, edited, or deleted individually in the project view.

### Future Enhancements

- Add **Spring Security** for user authentication and authorization.
- Implement **sorting** and **filtering** of projects based on task count or project name.
- Add **search functionality** for both projects and tasks.