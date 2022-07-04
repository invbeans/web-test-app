package ru.invbeans.repository;

import org.springframework.data.repository.CrudRepository;
import ru.invbeans.model.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
    List<User> findAll();
}
