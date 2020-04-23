package com.capgemini.springangular.service;

import java.util.List;

import com.capgemini.springangular.beans.ProductBean;

public interface ProductService {
	boolean updateProductInfo(ProductBean bean);
	boolean deleteProductInfo(String productName);
	boolean createProductInfo(ProductBean bean);
	List<ProductBean> getALLInfo();
	ProductBean getProductDetails(String productName);
}
