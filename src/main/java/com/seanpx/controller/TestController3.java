package com.seanpx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/test3")
public class TestController3 {

    @GetMapping("trigger_error")
    public String triggerError(Model model) {
        // Simulate an exception to test the GlobalExceptionHandler
        if (true) {
            throw new RuntimeException("This is a simulated runtime exception for testing purposes.");
        }

        // Normally, it would return a valid view name.
        return "test"; // Placeholder view, only if no exception is thrown.
    }
}
