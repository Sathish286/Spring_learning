package com.sathish.mobileapp;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sathish.mobileapp.Exception.ExceptionMessage;
import com.sathish.mobileapp.Exception.UserException;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object> handleExceptions(Exception ex,WebRequest request){
		
		String errorMessage = ex.getLocalizedMessage();
		if(ex.getLocalizedMessage()==null) {
			errorMessage=ex.toString();
		}
		ExceptionMessage message = new ExceptionMessage(new Date(),errorMessage);
		return new ResponseEntity<Object>(message,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value= {NullPointerException.class})
	public ResponseEntity<Object> handleNullPointerExceptions(Exception ex,WebRequest request){
		
		String errorMessage = ex.getLocalizedMessage();
		if(ex.getLocalizedMessage()==null) {
			errorMessage=ex.toString();
		}
		ExceptionMessage message = new ExceptionMessage(new Date(),errorMessage);
		return new ResponseEntity<Object>(message,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(value= {UserException.class})
	public ResponseEntity<Object> handleCustomExceptions(Exception ex,WebRequest request){
		
		String errorMessage = ex.getLocalizedMessage();
		if(ex.getLocalizedMessage()==null) {
			errorMessage=ex.toString();
		}
		ExceptionMessage message = new ExceptionMessage(new Date(),errorMessage);
		return new ResponseEntity<Object>(message,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
