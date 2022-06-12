package de.thb.Flight.Controller;


import de.thb.Flight.Entity.User;
import de.thb.Flight.Service.UserService;
import de.thb.Flight.exceptions.RecordAlreadyPresentException;
import de.thb.Flight.exceptions.RecordNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@Controller
@AllArgsConstructor
@RequestMapping("/User")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    @ExceptionHandler(RecordAlreadyPresentException.class)
    public void addUser(@RequestBody User newUser) {

        userService.createUser(newUser);
    }

    @GetMapping("/readAllUsers")
    public Iterable<User> readAllUsers() {

        return userService.displayAllUser();
    }

    @PutMapping("/updateUser")
    @ExceptionHandler(RecordNotFoundException.class)
    public void updateUser(@RequestBody User updateUser) {

        userService.updateUser(updateUser);
    }

    @GetMapping("/searchUser/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> searchUserByID(@PathVariable("id") BigInteger userId) {

        return userService.findUserById(userId);
    }

    @DeleteMapping("/deleteUser/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public void deleteBookingByID(@PathVariable("id") BigInteger userId) {

        userService.deleteUser(userId);
    }
}
