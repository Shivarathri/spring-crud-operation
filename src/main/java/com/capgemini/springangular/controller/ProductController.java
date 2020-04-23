package com.capgemini.springangular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springangular.beans.ProductBean;
import com.capgemini.springangular.beans.ProductResponce;
import com.capgemini.springangular.service.ProductService;
@RestController
public class ProductController {
	@Autowired
	private ProductService service;

	@GetMapping(path="/getProduct", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ProductBean getProduct(String productName) {
		ProductBean productInfo = service.getProductDetails(productName);

		return productInfo;
	}

	@PostMapping(path = "/addProduct", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE})
	@ResponseBody
	public ProductResponce addProduct(@RequestBody ProductBean bean) {
		boolean isAdded = service.createProductInfo(bean);
		ProductResponce responce = new ProductResponce();
		if (isAdded) {

			responce.setMessage("Record is inserted");
		} else {
			responce.setError(true);
			responce.setMessage("Unable to Add Product");
		}
		return responce;
	}

	@GetMapping(path = "/getAllProduct", produces = MediaType.APPLICATION_JSON_VALUE)
	//@ResponseBody
	public ProductResponce getAllProduct() {
		List<ProductBean> productList = service.getALLInfo();
		ProductResponce response = new ProductResponce();
		if (productList != null && !productList.isEmpty()) {
			response.setProductList(productList);

		} else {
			response.setError(true);
			response.setMessage("No data present");
		}
		return response;
	}
	@DeleteMapping(path = "/deleteProduct/{productName}", produces = MediaType.APPLICATION_JSON_VALUE)
	//@ResponseBody
	public ProductResponce deleteProduct(@PathVariable(name = "productName") String productName) {
		boolean isDeleted = service.deleteProductInfo(productName);
		ProductResponce response = new ProductResponce();
		if (isDeleted) {
			response.setMessage("Record is  Deleted");
		} else {
			response.setError(true);
			response.setMessage("Record is not Deleted");
		}
		return response;
	}


	@PutMapping(path = "/updateProduct", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ProductResponce updateProduct(ProductBean bean) {
		boolean isUpdated = service.updateProductInfo(bean);
		ProductResponce responce = new ProductResponce();
		if (isUpdated) {

			responce.setMessage("Record is Updated");
		} else {
			responce.setError(true);
			responce.setMessage("Record is not Updated");
		}
		return responce;
	}
}
