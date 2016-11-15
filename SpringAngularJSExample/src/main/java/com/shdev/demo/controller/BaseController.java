package com.shdev.demo.controller;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseController {
    private static final Logger logger = Logger.getLogger(BaseController.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleException(HttpServletRequest request, Exception e) {
        ModelAndView modelAndView = new ModelAndView("common/error");
        modelAndView.addObject("message", e.getMessage());
        modelAndView.addObject("exception", ExceptionUtils.getStackTrace(e));
        logger.error("message: " + e.getMessage());
        logger.error("exception: " + ExceptionUtils.getStackTrace(e));

        return modelAndView;
    }
}
