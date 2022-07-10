package ru.invbeans.repository;

import org.springframework.data.repository.CrudRepository;
import ru.invbeans.model.domain.Test;

public interface TestRepository extends CrudRepository<Test, Long> {
}
