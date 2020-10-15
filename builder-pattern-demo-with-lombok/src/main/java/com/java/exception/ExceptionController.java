package com.java.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(WrongDataInsertionException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public @ResponseBody ExceptionResponse dataInsettionException(final WrongDataInsertionException exception, final HttpServletRequest request) {

		ExceptionResponse response = new ExceptionResponse();
		response.setMessage(exception.getMessage());
		response.setUrl(request.getRequestURI());

		return response;
	}

}
