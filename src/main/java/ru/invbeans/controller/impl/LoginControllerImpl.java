package ru.invbeans.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;
import ru.invbeans.controller.LoginController;
import ru.invbeans.model.domain.Role;
import ru.invbeans.model.domain.User;
import ru.invbeans.model.dto.UserDto;
import ru.invbeans.service.UserService;

@RestController
@RequiredArgsConstructor
public class LoginControllerImpl implements LoginController {
    private final UserService userService;
    private final BCryptPasswordEncoder encoder;

    @Override
    public ResponseEntity<UserDto> logUser(UserDto dto){
        User user = userService.findForLogin(dto.getUsername());
        if(user == null){
            UserDto notFound = new UserDto();
            notFound.setUsername("none");
            notFound.setPassword("none");
            return ResponseEntity.ok(notFound);
        }
        if(!encoder.matches(dto.getPassword(), user.getPassword())){
            UserDto notFound = new UserDto();
            notFound.setUsername("none");
            notFound.setPassword("none");
            return ResponseEntity.ok(notFound);
        }
        if(user.getRoles().contains(new Role(2L, "ROLE_ADMIN"))){
            dto.setRole("ROLE_ADMIN");
        }
        else {
            dto.setRole("ROLE_USER");
        }
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        return ResponseEntity.ok(dto);
    }

    @Override
    public String check() {
        return "Working";
    }
}
