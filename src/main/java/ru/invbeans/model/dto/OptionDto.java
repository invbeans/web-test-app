package ru.invbeans.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class OptionDto {
    private Long id;
    private Long question;
    private String name;
    private boolean correct;

    public boolean getCorrect() {
        return correct;
    }
}
