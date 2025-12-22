# Project Management System 

## Overview
This project is a minimal full-stack example:
  - Backend: Java Servlet + JDBC (Maven WAR). Exposes REST-like endpoints under `/api/*`.
  - Frontend: Static HTML/JS that calls backend using `fetch()`.

## Setup (quick)
1. Install MySQL and run `sql/schema.sql`.
2. Edit `backend/src/main/java/com/projectmanagement/util/DBConnection.java` to set your DB username/password.
3. Build & run with Jetty plugin (Maven):
   ```
   cd backend
   mvn clean package
   mvn jetty:run
   ```
   The app will be available at `http://localhost:8080/` and the frontend will load from the webapp root.

4. Alternatively, package the WAR (`mvn package`) and deploy the WAR to Tomcat.

## Files
- backend/: Maven webapp (Java servlet backend)
- backend/src/main/webapp/static/: frontend JS/CSS/HTML
- sql/schema.sql: database schema


## Notes
- Uses Gson for JSON handling (maven dependency included).
- Servlet API scope is `provided` — use Tomcat/Jetty to run.

## Review 2 Details

### Code Quality & Testing
- The project is implemented using modular Java Servlets with clear separation of concerns.
- Proper exception handling is implemented using try-catch blocks.
- Input validation is performed on both client-side and server-side.
- All CRUD operations (Create, Read, Update, Delete) for Users, Projects, and Tasks were tested manually.
- The application handles invalid inputs and runtime errors without crashing.

### Teamwork & Collaboration
- This project was developed as a team project.
- I was primarily responsible for designing, coding, database integration, and integrating the core modules of the application.
- Team members contributed by assisting with documentation, testing, and review feedback.
- GitHub was used for version control and collaborative project management.

### Innovation / Extra Effort
- Both client-side and server-side data validation have been implemented.
- User-friendly success and error messages are displayed after each operation.
- A clean and simple user interface is used to improve usability.
- Future scope has been planned for adding authentication, role-based access, and advanced reporting features.


