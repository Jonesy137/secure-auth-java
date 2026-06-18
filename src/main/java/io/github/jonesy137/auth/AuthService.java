package io.github.jonesy137.auth;

public class AuthService {
    private final PasswordHasher passwordHasher;
    private User registeredUser;

    public AuthService(PasswordHasher passwordHasher) {
        this.passwordHasher = passwordHasher;
    }

    public void register(String email, String plainPassword) {
        String passwordHash = passwordHasher.hashPassword(plainPassword);
        registeredUser = new User(email, passwordHash);
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
