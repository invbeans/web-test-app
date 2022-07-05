package ru.invbeans.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    private String name;
    private OptionDto[] options;
}
