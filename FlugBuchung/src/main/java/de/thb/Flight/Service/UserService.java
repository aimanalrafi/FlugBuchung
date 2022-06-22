package de.thb.Flight.Service;

import de.thb.Flight.Entity.User;
import org.springframework.data.domain.Page;

import java.util.List;


public interface UserService  {

    public abstract Page<User> getAllUserPaged(int pageNum);
    public abstract List<User> getAllUser();
    public abstract User getUserById(Long userId);
    public abstract User saveUser(User user);
    public abstract void deleteUserById(Long userId);
}
