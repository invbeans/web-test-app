package ru.invbeans.repository;

import org.springframework.data.repository.CrudRepository;
import ru.invbeans.model.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
