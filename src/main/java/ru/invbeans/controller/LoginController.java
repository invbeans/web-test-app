package ru.invbeans.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.invbeans.model.dto.UserDto;

@RequestMapping(LoginController.MAPPING)
public interface LoginController {
    String MAPPING = "/login";

    @PostMapping()
    ResponseEntity<UserDto> logUser(@RequestBody() UserDto dto);

    @GetMapping()
    String check();
}
