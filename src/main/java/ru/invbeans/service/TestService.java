package ru.invbeans.service;

import ru.invbeans.model.dto.TestDto;

import java.util.List;

public interface TestService {
    Long saveTest(TestDto dto);

    List<TestDto> getAll();
}
