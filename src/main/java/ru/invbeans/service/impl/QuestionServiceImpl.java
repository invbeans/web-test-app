package ru.invbeans.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.invbeans.model.domain.Question;
import ru.invbeans.model.domain.Test;
import ru.invbeans.model.dto.QuestionDto;
import ru.invbeans.repository.QuestionRepository;
import ru.invbeans.service.OptionService;
import ru.invbeans.service.QuestionService;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository repository;
    private final OptionService optionService;
    private final EntityManager em;

    @Override
    public Long saveQuestion(QuestionDto dto) {
        Question question = new Question();
        question.setName(dto.getName());
        question.setOneAnswer(dto.getOneAnswer());
        question.setTest(em.find(Test.class, dto.getTest()));
        repository.save(question);
        for(int i = 0; i < dto.getOptions().length; i++){
            dto.getOptions()[i].setQuestion(question.getId());
            optionService.saveOption(dto.getOptions()[i]);
        }
        return question.getId();
    }
}
