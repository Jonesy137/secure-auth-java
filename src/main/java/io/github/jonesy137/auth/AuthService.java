package io.github.jonesy137.auth;

/**
 * Handles authentication rules for registering and logging in users.
 * Currently, stores one user in memory until database support is added.
 */

public class AuthService {
    private final PasswordHasher passwordHasher;
    private User registeredUser;

    public AuthService(PasswordHasher passwordHasher) {
        this.passwordHasher = passwordHasher;
    }

    /**
     * Registers a user if no user is currently registered and the input is valid.
     *
     * @param email the user's email address
     * @param plainPassword the user's plaintext password
     * @return true if registration succeeds, false otherwise
     */

    public boolean register(String email, String plainPassword) {
        //if registered already, registration fails
        if (registeredUser != null) {
            return false;
        }

        if (email.isBlank() || plainPassword.isBlank()) {
            return false;
        }

        String passwordHash = passwordHasher.hashPassword(plainPassword);
        registeredUser = new User(email, passwordHash);
        return true;
    }

    /**
     * Attempts to log in a user with the provided email and password.
     *
     * @param email the email entered by the user
     * @param plainPassword the password entered by the user
     * @return true if the login details are valid, false otherwise
     */

    public boolean login(String email, String plainPassword) {
        if (registeredUser == null) {
            return false;
            //if user hasn't registered yet
            //return false
        }

        if (email.isBlank() || plainPassword.isBlank()) {
            return false;
        }

        if (!registeredUser.getEmail().equals(email)) {
            return false;
            //if email entered doesn't = registered email
            //return false
        }

        return passwordHasher.verifyPassword(plainPassword, registeredUser.getPasswordHash());
        //if email matches -> check password using bcrypt
    }
}
