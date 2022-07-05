package ru.invbeans.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.invbeans.model.dto.UserDto;

import javax.validation.Valid;

@RequestMapping(RegistrationController.MAPPING)
public interface RegistrationController {
    String MAPPING = "/registration";

    @GetMapping()
    String registration(Model model);

    @PostMapping()
    String addUser(@ModelAttribute("userForm") @Valid UserDto userForm, BindingResult bindingResult, Model model);
}
