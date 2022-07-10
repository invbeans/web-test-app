package ru.invbeans.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.invbeans.model.domain.Option;
import ru.invbeans.model.domain.Question;
import ru.invbeans.model.domain.Test;
import ru.invbeans.model.dto.OptionDto;
import ru.invbeans.model.dto.QuestionDto;
import ru.invbeans.model.dto.TestDto;
import ru.invbeans.repository.TestRepository;
import ru.invbeans.service.QuestionService;
import ru.invbeans.service.TestService;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    private final TestRepository repository;
    private final QuestionService questionService;
    private final EntityManager em;

    @Override
    public Long saveTest(TestDto dto) {

        Test test = new Test();
        test.setName(dto.getName());
        repository.save(test);

        for(int i = 0; i < dto.getQuestions().length; i++){
            dto.getQuestions()[i].setTest(test.getId());
            questionService.saveQuestion(dto.getQuestions()[i]);
        }
        return test.getId();
    }

    @Override
    public List<TestDto> getAll() {
        List<Test> tests = (List<Test>) repository.findAll();
        List<TestDto> testDtos = new ArrayList<>();
        for(Test elem: tests){
            TestDto temp = new TestDto();
            temp.setId(elem.getId());
            temp.setName(elem.getName());
            Object[] quesObjDtos = elem.getQuestions().toArray();
            Question[] questionArray = Arrays.copyOf(quesObjDtos, quesObjDtos.length, Question[].class);
            QuestionDto[] quesDtos = new QuestionDto[questionArray.length];
            for(int i = 0; i < questionArray.length; i++){
                QuestionDto questionDto = new QuestionDto();
                questionDto.setId(questionArray[i].getId());
                questionDto.setName(questionArray[i].getName());
                questionDto.setTest(questionArray[i].getTest().getId());
                questionDto.setOneAnswer(questionArray[i].isOneAnswer());
                Object[] optObjDtos = questionArray[i].getOptions().toArray();
                Option[] optionArray = Arrays.copyOf(optObjDtos, optObjDtos.length, Option[].class);
                OptionDto[] optDtos = new OptionDto[optionArray.length];
                for(int j = 0; j < optionArray.length; j++){
                    OptionDto optionDto = new OptionDto();
                    optionDto.setId(optionArray[j].getId());
                    optionDto.setQuestion(optionArray[j].getQuestion().getId());
                    optionDto.setCorrect(optionArray[j].isCorrect());
                    optionDto.setName(optionArray[j].getName());
                    optDtos[j] = optionDto;
                }
                questionDto.setOptions(optDtos);
                quesDtos[i] = questionDto;
            }
            temp.setQuestions(quesDtos);
            testDtos.add(temp);
        }
        return testDtos;
    }
}
