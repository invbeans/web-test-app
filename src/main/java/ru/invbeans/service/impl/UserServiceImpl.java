package ru.invbeans.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.invbeans.model.domain.Role;
import ru.invbeans.model.domain.User;
import ru.invbeans.model.dto.UserDto;
import ru.invbeans.repository.UserRepository;
import ru.invbeans.service.UserService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<User> userOptional = userRepository.findByUsername(username);
        if(!userOptional.isPresent()){
            return null;
        }
        User user = userOptional.get();
        String authority = (user.getRoles().contains("ROLE_ADMIN")) ? "ROLE_ADMIN" : "ROLE_USER";
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(authority)
                .roles(String.valueOf(user.getRoles()))
                .build();
    }

    @Override
    public User findForLogin(String username){
        Optional<User> optionalUser = userRepository.findByUsername(username);
        return optionalUser.orElse(null);
    }

    @Override
    public User findUserById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public List<User> allUsers(){
        return userRepository.findAll();
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        Optional<User> optionalUser = userRepository.findByUsername(userDto.getUsername());
        if(optionalUser.isPresent()){
            return null;
        }
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(encoder.encode(userDto.getPassword()));
        userRepository.save(user);
        userDto.setId(user.getId());
        return userDto;
    }

    @Override
    public boolean deleteUser(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
