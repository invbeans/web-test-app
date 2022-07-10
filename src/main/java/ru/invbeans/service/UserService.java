package ru.invbeans.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.invbeans.model.domain.User;
import ru.invbeans.model.dto.UserDto;

import java.util.List;

public interface UserService extends UserDetailsService {
    User findUserById(Long id);
    List<User> allUsers();
    UserDto saveUser(UserDto userDto);

    User findForLogin(String username);
    boolean deleteUser(Long id);
}
