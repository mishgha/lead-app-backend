# Lead Management Module Documentation

## 1. Background

### ○ Purpose:
The **Lead Management Module** provides a RESTful API for creating, retrieving, updating, and deleting lead records. It ensures clean separation between internal models and external representations via DTOs and offers validation for consistent and secure data input. It is designed to serve as a backend system for managing leads, communicating with a frontend client over HTTP/JSON.

### ○ Tech Stack:

**Core:**
- **Spring Boot 3.4.4** – Application framework (via `spring-boot-starter-parent`)
- **Java 17** – Source and target compatibility level

**Dependencies:**
- `spring-boot-starter-web` – For building RESTful web services
- `spring-boot-starter-data-jpa` – For JPA and database interaction
- `spring-boot-starter-validation` – For bean validation (Jakarta Validation)
- `liquibase-core` – For managing database schema migrations
- `H2 Database` – In-memory database for development/testing
- `mapstruct`, `mapstruct-processor` – For entity-to-DTO mapping
- `lombok`, `lombok-mapstruct-binding` – To reduce boilerplate code
- `spring-boot-starter-test` – For testing (unit and integration)

### ○ Setup Instructions:

1. Clone the repository:
   ```bash
   git clone (https://github.com/mishgha/lead-app-backend.git)

2. Navigate into the project:
   ```bash
   cd lead-app
   
3. Run the application:
   ```bash
   ./mvnw spring-boot:run

4. Access the application:
    Swagger UI: [API Docs](https://lead-app-backend-n4bm.onrender.com/swagger-ui/index.html)
    Frontend: [Frontend UI](https://lead-app-frontend.vercel.app/)


## 2. Module Requirement

### ○ Functional Requirements:

- **Lead Management** :
CRUD operations for leads
Fields: name, contact information, source

- **Validation** :
Jakarta Bean Validation annotations (@NotNull, @Email, etc.)

- **API Communication** :
JSON-based REST APIs

- **Data Persistence** :
Spring Data JPA repositories

- **DTO to Entity Conversion** :
Handled via MapStruct

- **Schema Management** :
Liquibase for schema migrations

- **Testing** :
Unit and integration testing with Spring Boot Test

### ○ Non - Functional Requirements:
- Maintainable code structure
- Auto-deployment to Render (BE) and Vercel (FE)
- Version-controlled schema
- Layered architecture separation

## 3. Module / Feature Implementation Detail
### ○ Folder Structure:

```text
lead-app/
├── src/
│   ├── main/
│   │   ├── java/com/example/leadapp/
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── dto/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── mapper/
│   │   │   └── LeadAppApplication.java
│   │   └── resources/
│   │       ├── application.yml
│   │       └── db/changelog/
│   │           └── db.changelog-master.yaml
├── src/test/java/com/example/leadapp/
│   └── LeadAppApplicationTests.java
├── pom.xml
```

### ○ Component Description:
- **controller/** – REST API handlers
- **service/** – Business logic
- **dto/** – External-facing data models
- **model/** – JPA entities (DB structure)
- **repository/** – Interfaces for CRUD ops
- **mapper/** – MapStruct classes for DTO/entity conversion
- **application.yml** – Configuration settings
- **Liquibase changelogs** – Located under resources/db/changelog


## 4. API Documentation:
- **API Docs** : https://lead-app-backend-n4bm.onrender.com/swagger-ui/index.html

## 5. Deployment:
- **BE Deployment** : render.com
- **FE Deployment** : vercel.com
- **How** : Auto-deployed on code push to main branch. EOF





