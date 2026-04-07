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


