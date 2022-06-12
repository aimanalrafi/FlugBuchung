package de.thb.Flight.Service;

import de.thb.Flight.Entity.User;
import de.thb.Flight.Repository.UserRepository;
import de.thb.Flight.exceptions.RecordAlreadyPresentException;
import de.thb.Flight.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository ;

    @Override
    public ResponseEntity<?> createUser(User newUser) {
        Optional<User> findUserById = userRepository.findById(newUser.getUserId());
        try {
            if (!findUserById.isPresent()) {
                userRepository.save(newUser);
                return new ResponseEntity<User>(newUser, HttpStatus.OK);
            } else
                throw new RecordAlreadyPresentException(
                        "User with Id: " + newUser.getUserId() + " already exists!!");
        } catch (RecordAlreadyPresentException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @Override
    public User updateUser(User updateUser) {
        Optional<User> findUserById = userRepository.findById(updateUser.getUserId());
        if (findUserById.isPresent()) {
            userRepository.save(updateUser);
        } else
            throw new RecordNotFoundException(
                    "User with Id: " + updateUser.getUserId() + " not exists!!");
        return updateUser;
    }

    @Override
    public String deleteUser(BigInteger UserId) {
        Optional<User> findBookingById = userRepository.findById(UserId);
        if (findBookingById.isPresent()) {
            userRepository.deleteById(UserId);
            return "User Deleted!!";
        } else
            throw new RecordNotFoundException("User not found for the entered UserID");
    }

    @Override
    public Iterable<User> displayAllUser() {
        return userRepository.findAll();
    }

    @Override
    public ResponseEntity<?> findUserById(BigInteger userId) {

        Optional<User> findById = userRepository.findById(userId);
        try {
            if (findById.isPresent()) {
                User findUser = findById.get();
                return new ResponseEntity<User>(findUser, HttpStatus.OK);
            } else
                throw new RecordNotFoundException("No record found with ID " + userId);
        } catch (RecordNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}