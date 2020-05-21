package br.com.longping.handler;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.longping.error.*;
import br.com.longping.error.ResourceNotFoundDetails.Builder;
import br.com.longping.error.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandle {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundExcepetion(ResourceNotFoundException rfnException){
		ResourceNotFoundDetails.Builder.newBuilder().withTimestamp(new Date().getTime())
		.withStatus(HttpStatus.NOT_FOUND.value())
		.withTitle("Resource not found")
		.withDetail(rfnException.getMessage())
		.withDeveloperMessage(rfnException.getClass().getName());
		Builder.newBuilder();
	return new ResponseEntity<>(rfnException,HttpStatus.NOT_FOUND);
		
	}

}
