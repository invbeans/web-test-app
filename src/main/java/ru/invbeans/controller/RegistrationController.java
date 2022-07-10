package ru.invbeans.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.invbeans.model.dto.UserDto;

import javax.validation.Valid;

@RequestMapping(RegistrationController.MAPPING)
public interface RegistrationController {
    String MAPPING = "/registration";


    @PostMapping()
    ResponseEntity<UserDto> addUser(@RequestBody(required = false) UserDto dto);
}
