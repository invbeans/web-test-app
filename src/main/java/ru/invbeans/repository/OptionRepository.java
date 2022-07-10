package ru.invbeans.repository;

import org.springframework.data.repository.CrudRepository;
import ru.invbeans.model.domain.Option;

public interface OptionRepository extends CrudRepository<Option, Long> {
}
