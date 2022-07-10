package ru.invbeans.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.invbeans.model.dto.TestDto;

import java.util.List;

@RequestMapping(FeedController.MAPPING)
public interface FeedController {
    String MAPPING = "/feed";

    @GetMapping("/tests_info")
    ResponseEntity<List<TestDto>> getTestsInfo();
}
