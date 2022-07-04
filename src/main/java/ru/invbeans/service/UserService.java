package ru.invbeans.service;

import org.springframework.security.core.userdetails.UserDetails;
import ru.invbeans.model.domain.User;

import java.util.List;

public interface UserService {
    User findUserById(Long id);
    List<User> allUsers();
    boolean saveUser(User user);
    boolean deleteUser(Long id);
}
