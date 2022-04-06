package com.alex.sms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

// TODO: Auto-generated Javadoc
/**
 * The global default exception handler.
 *
 */

// https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

/** The Constant DEFAULT_ERROR_VIEW. */
public static final String DEFAULT_ERROR_VIEW = "error";
	
	/**
	 * Default error handler.
	 *
	 * @param req the req
	 * @param e the e
	 * @return the string
	 * @throws Exception the exception
	 */
	@ExceptionHandler(value = Exception.class)
	public String defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
			throw e;
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return "error/404";
	}
}
