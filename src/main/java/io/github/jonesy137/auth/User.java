package io.github.jonesy137.auth;

/**
 * Represents a registered user account.
 * Stores the email and hashed password, never the plaintext password.
 */

public class User {
    private String email;
    private String passwordHash;

    public User(String email, String passwordHash) {
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
