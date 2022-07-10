package ru.invbeans.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.invbeans.controller.RegistrationController;
import ru.invbeans.model.dto.UserDto;
import ru.invbeans.service.UserService;

@RestController
@RequiredArgsConstructor
public class RegistrationControllerImpl implements RegistrationController {
    private final UserService userService;

    @Override
    public ResponseEntity<UserDto> addUser(UserDto dto) {
        UserDto savedDto = userService.saveUser(dto);
        return ResponseEntity.ok(savedDto);
    }
}
