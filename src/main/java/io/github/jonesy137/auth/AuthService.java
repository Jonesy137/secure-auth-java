package io.github.jonesy137.auth;

public class AuthService {
    private final PasswordHasher passwordHasher;
    private User registeredUser;

    public AuthService(PasswordHasher passwordHasher) {
        this.passwordHasher = passwordHasher;
    }

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

    public boolean login(String email, String plainPassword) {
        if (registeredUser == null) {
            return false;
            //if user hasn't registered yet
            //return false
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
