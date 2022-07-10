package ru.invbeans.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.invbeans.model.domain.User;

import java.util.List;

@RequestMapping(AdminController.MAPPING)
public interface AdminController {
    String MAPPING = "/admin";

    @GetMapping("/user_list")
    ResponseEntity<List<User>> getAllUsers();

    @PostMapping("/save_test")
    ResponseEntity<String> saveTest(@RequestBody(required = true)String testJson) throws JsonProcessingException;
}
