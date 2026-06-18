package io.github.jonesy137.auth;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Handles password hashing and password verification.
 * Uses bcrypt so plaintext passwords are not stored directly.
 */

public class PasswordHasher {

    /**
     * Hashes a plaintext password using bcrypt.
     *
     * @param plainPassword the password entered by the user
     * @return the bcrypt hash to store
     */

    public String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
        //gensalt() creates a random salt
        //hashpw(..) hashes plaintext password with that salt
    }

    /**
     * Verifies a plaintext password against a stored bcrypt hash.
     *
     * @param plainPassword the password entered by the user
     * @param storedHash the previously stored bcrypt hash
     * @return true if the password matches, false otherwise
     */

    public boolean verifyPassword(String plainPassword, String storedHash) {
        return BCrypt.checkpw(plainPassword, storedHash);
    }
}
