package com.capgemini.springangular.beans;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ProductResponce {
	private boolean error;
	private String message;
	private ProductBean productInfo;
	private List<ProductBean> productList;
}
