package com.aixel.training.concurrency.controller;

import com.aixel.training.concurrency.entity.Log;
import com.aixel.training.concurrency.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("Log")
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;

    @PostMapping(value = "/book/{id}")
    public Log bookLog(@PathVariable final String id) {
        try {
            return logService.book(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
