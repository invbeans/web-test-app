package ru.invbeans.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.invbeans.model.domain.Role;
import ru.invbeans.model.domain.User;
import ru.invbeans.repository.RoleRepository;
import ru.invbeans.repository.UserRepository;
import ru.invbeans.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserDetailsService, UserService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<User> userOptional = userRepository.findByUsername(username);
        if(!userOptional.isPresent()){
            throw new UsernameNotFoundException("User not found");
        }
        return userOptional.get();
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
    public boolean saveUser(User user) {
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
        if(!optionalUser.isPresent()){
            return false;
        }
        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
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
