package ru.invbeans.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.invbeans.controller.AdminController;
import ru.invbeans.model.domain.User;
import ru.invbeans.model.dto.OptionDto;
import ru.invbeans.model.dto.QuestionDto;
import ru.invbeans.model.dto.TestDto;
import ru.invbeans.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class AdminControllerImpl implements AdminController {
    private final UserService userService;

    @Override
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.allUsers());
    }

    @Override
    public ResponseEntity<String> saveTest(String testJson) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String name = mapper.readTree(testJson).get("name").asText();
        List<QuestionDto> questionDtos = new ArrayList<>();
        for (Iterator<JsonNode> it = mapper.readTree(testJson).get("questions").elements(); it.hasNext(); ) {
            JsonNode elem = it.next();
            QuestionDto questionDto = new QuestionDto();
            questionDto.setName(elem.get("name").asText());
            questionDto.setOneAnswer(elem.get("oneAnswer").asBoolean());
            List<OptionDto> optionDtos = new ArrayList<>();
            for(Iterator<JsonNode> iter = elem.get("options").elements(); iter.hasNext();){
                JsonNode innerElem = iter.next();
                OptionDto optionDto = new OptionDto();
                optionDto.setName(innerElem.get("name").asText());
                optionDto.setCorrect(innerElem.get("correct").asBoolean());
                optionDtos.add(optionDto);
            }
            Object[] optObjDtos = optionDtos.toArray();
            OptionDto[] optDtos = Arrays.copyOf(optObjDtos, optObjDtos.length, OptionDto[].class);
            questionDto.setOptions(optDtos);
            questionDtos.add(questionDto);
        }
        TestDto testDto = new TestDto();
        testDto.setName(name);
        Object[] quesObjDtos = questionDtos.toArray();
        QuestionDto[] quesDtos = Arrays.copyOf(quesObjDtos, quesObjDtos.length, QuestionDto[].class);

        testDto.setQuestions(quesDtos);
        return ResponseEntity.ok("Test saved");
    }
}
