package ru.invbeans.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.invbeans.model.domain.Option;
import ru.invbeans.model.domain.Question;
import ru.invbeans.model.dto.OptionDto;
import ru.invbeans.repository.OptionRepository;
import ru.invbeans.service.OptionService;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class OptionServiceImpl implements OptionService {
    private final OptionRepository repository;
    private final EntityManager em;

    @Override
    public Long saveOption(OptionDto dto) {
        Option option = new Option();
        option.setName(dto.getName());
        option.setCorrect(dto.getCorrect());
        option.setQuestion(em.find(Question.class, dto.getQuestion()));
        repository.save(option);
        return option.getId();
    }
}
