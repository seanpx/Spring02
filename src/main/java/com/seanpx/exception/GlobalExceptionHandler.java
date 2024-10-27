package com.seanpx.exception;

import com.seanpx.utils.JsonData;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handles all ArithmeticExceptions in the application
    @ExceptionHandler(ArithmeticException.class)
    public JsonData handleArithmeticException(ArithmeticException exception) {
        return JsonData.buildError("Global Arithmetic Exception: " + exception.getMessage());
    }

    // Handles all other exceptions
    /* Comment out below to test out Customized error.html via thymeleaf

    @ExceptionHandler(Exception.class)
    public JsonData handleException(Exception exception) {
        return JsonData.buildError("An unexpected error occurred: " + exception.getMessage());
    }

     */

    //Below handling returns error via error.html
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return new ModelAndView("error"); // Refers to the Thymeleaf template "error.html"
    }

}

