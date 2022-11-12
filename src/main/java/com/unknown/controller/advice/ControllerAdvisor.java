package com.unknown.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.unknown.custom.exception.AuthorizationException;
import com.unknown.custom.exception.CustomSQLException;
import com.unknown.custom.exception.ErrorGeneralException;
import com.unknown.custom.exception.FieldNotFoundException;
import com.unknown.custom.exception.FormatException;
import com.unknown.model.ResponseModel;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	@ExceptionHandler(FieldNotFoundException.class)
	public ResponseEntity<ResponseModel> handleFieldNotFoundException(FieldNotFoundException ex,
			WebRequest webRequest) {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setData(null);
		responseModel.setError(ex.getMessage());
		return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(FormatException.class)
	public ResponseEntity<ResponseModel> handleFormatException(FormatException ex, WebRequest webRequest) {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setData(null);
		responseModel.setError(ex.getMessage());
		return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<ResponseModel> handleAuthorizationException(AuthorizationException ex,
			WebRequest webRequest) {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setData(null);
		responseModel.setError(ex.getMessage());
		return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(CustomSQLException.class)
	public ResponseEntity<ResponseModel> handleFieldNotFoundException(CustomSQLException ex, WebRequest webRequest) {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setData(null);
		responseModel.setError(ex.getMessage());
		return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ErrorGeneralException.class)
	public ResponseEntity<ResponseModel> handleFieldNotFoundException(ErrorGeneralException ex, WebRequest webRequest) {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setData(null);
		responseModel.setError(ex.getMessage());
		return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseModel> handleFieldNotFoundException(Exception ex, WebRequest webRequest) {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setData(null);
		responseModel.setError(ex.getMessage());
		return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}