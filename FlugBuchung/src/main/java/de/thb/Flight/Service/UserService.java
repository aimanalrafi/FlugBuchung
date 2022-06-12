package de.thb.Flight.Service;

import de.thb.Flight.Entity.User;
import org.springframework.http.ResponseEntity;

import java.math.BigInteger;

public interface UserService {
    public ResponseEntity<?> createUser(User newUser);

    public User updateUser(User newUser);

    public String deleteUser(BigInteger UserId);

    public Iterable<User> displayAllUser();

    public ResponseEntity<?> findUserById(BigInteger userId);
}
