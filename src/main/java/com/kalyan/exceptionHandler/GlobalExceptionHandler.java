package com.kalyan.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kalyan.error.Error;
import com.kalyan.errorcodes.ErrorCode;
import com.kalyan.exception.NoContactFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = NoContactFoundException.class)
	public ResponseEntity<Error> handleNoDataFoundException(NoContactFoundException noContactFoundException) {

		String message = noContactFoundException.getMessage();

		Error eb = new Error();

		eb.setCode(ErrorCode.ERROR_CODE);
		eb.setMsg(message);

		return new ResponseEntity<Error>(eb, HttpStatus.BAD_REQUEST);

	}

}
