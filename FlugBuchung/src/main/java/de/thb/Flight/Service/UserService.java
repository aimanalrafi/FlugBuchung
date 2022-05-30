package de.thb.Flight.Service;
import de.thb.Flight.Entity.User;
import de.thb.Flight.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(Long id) {
               return this.userRepository.findById(id);
    }

    public String deleteUserById(Long id) {
    Optional<User> user = this.getUserById(id);
    if(user.isPresent()) {
        this.userRepository.deleteById(user.get().getId());
        return "User Deleted .";
    }else{
        return "User Not Exist" ;
    }
    }

    public User updateUser(User user) {
        Optional<User> u = this.getUserById(user.getId());
        if (u.isPresent()) {
            return this.userRepository.save(user);
        } else {
            return null;
        }
    }
    public User saveUser(User user){

        return this.userRepository.save(user);
    }


    public List<User> getUserByVorname(String vorname){

        return this.userRepository.searchUserByVorname(vorname);
    }
    public List<User> getUserByNachname(String nachname){

        return this.userRepository.searchUserByVorname(nachname);
    }
}