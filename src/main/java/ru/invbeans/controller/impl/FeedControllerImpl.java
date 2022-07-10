package ru.invbeans.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.invbeans.controller.FeedController;
import ru.invbeans.model.dto.TestDto;
import ru.invbeans.service.TestService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FeedControllerImpl implements FeedController {
    private final TestService service;

    @Override
    public ResponseEntity<List<TestDto>> getTestsInfo() {
        return ResponseEntity.ok(service.getAll());
    }
}
