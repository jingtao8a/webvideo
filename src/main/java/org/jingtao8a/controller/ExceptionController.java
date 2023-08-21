package org.jingtao8a.controller;

import org.jingtao8a.model.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Throwable e) {
        return new Result(500, e.getMessage());
    }
}
