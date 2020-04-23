package com.capgemini.springangular.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.springangular.beans.ProductResponce;
import com.capgemini.springangular.exception.ProductException;

@RestControllerAdvice
public class MyRestControllerAdvice {
	@ExceptionHandler
	public ProductResponce myExceptionHandler(ProductException productException) {
		ProductResponce response = new ProductResponce();
		response.setError(true);
		response.setMessage(productException.getMessage());
		return response;
	}
}
