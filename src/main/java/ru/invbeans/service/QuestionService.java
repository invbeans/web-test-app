package ru.invbeans.service;

import ru.invbeans.model.dto.QuestionDto;

public interface QuestionService {
    Long saveQuestion(QuestionDto dto);
}
