# Booking System (Spring Boot + JWT)

## Features
- JWT Authentication
- Secure APIs
- Booking & Movie APIs

## Tech Stack
- Java
- Spring Boot
- Spring Security
- JWT
- MySQL

## Run
mvn spring-boot:run

**Explaintion:**
# 🎬 Booking System (Spring Boot + JWT)

## 📌 Overview

This project is a **Booking System** built using **Spring Boot** that allows users to securely log in and book movie tickets. The application uses **JWT (JSON Web Token)** for authentication and follows a **layered architecture** to ensure clean and maintainable code.

---

## 🏗️ Architecture

The application follows a standard **layered architecture**:

Client → Security (JWT Filter) → Controller → Service → Repository → Database → Response

* **Client**: Sends HTTP requests (Postman/UI)
* **Security Layer**: Validates JWT before processing request
* **Controller**: Handles API endpoints
* **Service**: Contains business logic
* **Repository**: Interacts with database using JPA
* **Database**: Stores user, movie, and booking data

---

## 🔐 Authentication Flow

1. User sends login request to `/auth/login`
2. Credentials are validated using Spring Security
3. If valid, a **JWT token** is generated
4. Token is returned to client
5. Client sends token in `Authorization` header for all secured APIs

---

## 🔄 Request Flow (Secured APIs)

1. Client sends request with JWT token
2. **JwtFilter** intercepts request
3. Token is validated (expiry + authenticity)
4. If valid → request proceeds
5. Controller → Service → Repository → Database
6. Response is returned to client

---

## 🔑 Key Components

### 🔹 JwtUtil

* Generates JWT token
* Extracts username
* Validates token
* Checks expiration

### 🔹 JwtFilter

* Intercepts every request
* Validates token before controller
* Blocks unauthorized access

### 🔹 SecurityConfig

* Configures Spring Security
* Allows `/auth/login`
* Secures all other endpoints

### 🔹 CustomUserDetailsService

* Loads user from database
* Integrates with Spring Security

---

## 🗃️ Database Design

### User

* id, username, password

### Movie

* id, name, availableSeats

### Booking

* id, userId, movieId, seatsBooked

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Security
* JWT (jjwt)
* Spring Data JPA
* MySQL
* Maven

---

## 🚨 Error Handling

* Invalid/Expired Token → 401 Unauthorized
* Missing Token → 401 Unauthorized
* Invalid Credentials → 403 Forbidden
* Seat Unavailability → Runtime Exception

---

## 💡 Key Features

* JWT-based authentication (stateless)
* Secure REST APIs
* Layered architecture
* Password encryption using BCrypt
* Clean separation of concerns

---

## 🚀 Future Improvements

* Role-based authorization (ADMIN / USER)
* Refresh tokens
* Microservices architecture
* API Gateway integration

---

## ▶️ Run the Project

```bash
mvn spring-boot:run
```

---

## 📌 Summary

This project demonstrates how to build a **secure, scalable backend system** using Spring Boot with JWT authentication, following best practices like layered architecture and stateless security.








**Login Follow:**
Client → /auth/login
        ↓
Controller
        ↓
AuthenticationManager
        ↓
UserDetailsService
        ↓
UserRepository → DB
        ↓
Password match (BCrypt)
        ↓
JwtUtil → generate token
        ↓
Response → TOKEN


**Booking follow**
Client → /bookings (with token)
        ↓
JwtFilter
        ↓
Token validated ✅
        ↓
Controller
        ↓
Service
        ↓
Repository
        ↓
Database
        ↓
Response returned


**JWT Internal follow:**
Generate Token:
Username → JwtUtil → Token

Use Token:
Header → JwtFilter → extract username → validate


        ┌──────────────┐
        │   Client     │
        │ (Postman/UI) │
        └──────┬───────┘
               │
               ▼
        ┌──────────────┐
        │ JwtFilter 🔐 │
        └──────┬───────┘
               │
        Token Valid? ❓
        ├───────────────┐
        │               │
        ▼               ▼
   ❌ Reject        ✅ Allow
 (401 Error)           │
                       ▼
              ┌──────────────┐
              │ Controller   │
              └──────┬───────┘
                     │
                     ▼
              ┌──────────────┐
              │  Service     │
              └──────┬───────┘
                     │
                     ▼
              ┌──────────────┐
              │ Repository   │
              └──────┬───────┘
                     │
                     ▼
              ┌──────────────┐
              │  Database    │
              └──────┬───────┘
                     │
                     ▼
              ┌──────────────┐
              │  Response    │
              └──────────────┘


              
