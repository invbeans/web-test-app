package ru.invbeans.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import ru.invbeans.controller.RegistrationController;
import ru.invbeans.model.domain.User;
import ru.invbeans.model.dto.UserDto;
import ru.invbeans.service.UserService;

@RestController
@RequiredArgsConstructor
public class RegistrationControllerImpl implements RegistrationController {

    private final UserService userService;

    @Override
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @Override
    public String addUser(UserDto userForm, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "registration";
        }
        if(!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Passwords aren't same");
            return "registration";
        }
        if(!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "User with this name already exists");
            return "registration";
        }
        return "redirect:/main";
    }
}
