package de.thb.Flight.Service;


import de.thb.Flight.Entity.User;
import de.thb.Flight.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository UserRepository;
    @Autowired
private UserRepository userRepository;




    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.UserRepository = userRepository;
    }

    @Override
    public Page<User> getAllUserPaged(int pageNum) {
        return userRepository.findAll(PageRequest.of(pageNum,5, Sort.by("lastName")));

    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();

    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);

    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);

    }
}
