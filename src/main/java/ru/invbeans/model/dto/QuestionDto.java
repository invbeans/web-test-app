package ru.invbeans.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    private Long id;
    private String name;
    private boolean oneAnswer;
    private Long test;
    private OptionDto[] options;

    public boolean getOneAnswer() {
        return oneAnswer;
    }
}
