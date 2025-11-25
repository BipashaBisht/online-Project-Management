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
- ORIGINAL_UPLOADED_PATH.txt: path to the original project zip you uploaded

## Notes
- Uses Gson for JSON handling (maven dependency included).
- Servlet API scope is `provided` — use Tomcat/Jetty to run.
