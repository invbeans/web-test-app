package ru.invbeans.service;

import ru.invbeans.model.domain.User;
import ru.invbeans.model.dto.UserDto;

import java.util.List;

public interface UserService {
    User findUserById(Long id);
    List<User> allUsers();
    boolean saveUser(UserDto userDto);
    boolean deleteUser(Long id);
}
