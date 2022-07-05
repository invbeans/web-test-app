package ru.invbeans.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class TestDto {
    private String name;
    private boolean oneAnswer;
    private QuestionDto[] questions;
}
