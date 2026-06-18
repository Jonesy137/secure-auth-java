package io.github.jonesy137.auth;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher {

    public String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
        //gensalt() creates a random salt
        //hashpw(..) hashes plaintext password with that salt
    }

    public boolean verifyPassword(String plainPassword, String storedHash) {
        return BCrypt.checkpw(plainPassword, storedHash);
    }
}
