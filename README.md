
# Secure Auth Java 🔐 (unfinished!)

Secure Auth Java is a terminal-based authentication project built in Java. The goal of this project is to practise secure password handling, object-oriented programming, and eventually database-backed user authentication.

At the current stage, the application allows a user to register and log in during the same program session. Passwords are not stored in plaintext. Instead, passwords are hashed using bcrypt before being stored in memory.

## Current Features

* Terminal-based menu
* User registration
* User login
* Password hashing using bcrypt
* Password verification using bcrypt
* Basic input validation
* Duplicate in-memory registration prevention
* Object-oriented class structure

## Security Concepts Practised

This project currently demonstrates the idea that plaintext passwords should not be stored directly.

When a user registers, their plaintext password is passed to a password-hashing class. The resulting hash is stored instead of the original password.

When a user logs in, the entered password is checked against the stored hash using bcrypt verification.

The login error message is intentionally generic:

```text
Invalid email or password.
```

This avoids revealing whether the email or password was the incorrect part.

## Technologies Used

* Java
* Maven
* bcrypt via jBCrypt

## Class Responsibilities

### Main

Handles the terminal menu and user input/output.

### User

Represents a registered user account. It stores the user's email and password hash, not the plaintext password.

### AuthService

Handles registration and login rules.

### PasswordHasher

Handles password hashing and password verification using bcrypt.
