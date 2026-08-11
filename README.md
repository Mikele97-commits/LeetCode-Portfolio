# LeetCode Portfolio

Interactive full-stack portfolio project that lets you browse and **run** LeetCode solutions in the browser.

> **Note:** This is a learning project.  
> I started with very limited experience and built this with heavy AI assistance (mainly for architecture decisions, Docker setup, debugging, and code structuring). The goal was to learn by building something real.

---

## Features

- Browse LeetCode problems by category (`LeetCode 75` and classic problems by ID)
- View problem description, difficulty, and solution code
- Execute solutions with custom input directly in the browser
- Clean dark-themed UI
- Fully containerized with Docker

---

## Current Status

- Exercises with simple parameter types (`String` and `int`) are fully working
- Array-based exercises are partially supported / still being improved
- Some edge cases and more advanced input types are planned for the future

---

## Tech Stack

**Frontend**
- Angular 19
- TypeScript
- Standalone components

**Backend**
- Java 21
- Spring Boot
- Custom exercise execution engine

**Infrastructure**
- Docker + Docker Compose
- Nginx (serves the frontend)

---

## Getting Started

### Prerequisites
- Docker Desktop

### Run the project

```bash
docker-compose up --build
```

Once the containers are running:

- Frontend → [http://localhost:4200](http://localhost:4200)
- Backend  → [http://localhost:8080](http://localhost:8080)

---

## Project Structure

```
LeetCode-Portfolio/
├── frontend/              # Angular application
├── backend/               # Spring Boot application
├── docker-compose.yml
└── README.md
```

---

## How it works

1. The Angular frontend displays the list of exercises and their details.
2. When you submit input, it sends a request to the Spring Boot backend.
3. The backend parses the input, executes the corresponding Java solution method, and returns the result.
4. The result is shown in the UI.

---

## Future improvements

- Full support for arrays and more complex input types
- Better error handling and input validation
- More exercises
- Dark/light mode toggle
- Improved documentation of individual solutions

---

## Author

Michał Minich  
Learning project built with significant help from AI tools.
