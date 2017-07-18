package ua.laksmi.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * Created by Dobriks on 23.04.2017.
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ModelAndView handleError405(HttpServletRequest request, Exception e)   {
        ModelAndView model = new ModelAndView("redirect:/404");

        return model;
    }
//    @ExceptionHandler(NoHandlerFoundException.class)
//    @ResponseStatus(value = HttpStatus.CONFLICT)
//    public String handle(Exception ex) {
//        return "forward:404";
//    }

    // for 403 access denied page

}
