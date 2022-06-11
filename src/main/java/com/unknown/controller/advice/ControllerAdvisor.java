package com.unknown.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.unknown.custom.exception.FieldNotFoundException;
import com.unknown.model.ResponseModel;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	@ExceptionHandler(FieldNotFoundException.class)
	public ResponseEntity<ResponseModel> handleFieldNotFoundException(FieldNotFoundException ex, WebRequest webRequest){
		ResponseModel responseModel = new ResponseModel();
		responseModel.setData(null);
		responseModel.setError(ex.getMessage());
		return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
