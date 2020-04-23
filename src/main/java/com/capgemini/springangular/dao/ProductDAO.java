package com.capgemini.springangular.dao;

import java.util.List;

import com.capgemini.springangular.beans.ProductBean;

public interface ProductDAO {
	boolean updateProductInfo(ProductBean bean);
	boolean deleteProductInfo(String productName);
	boolean createProductInfo(ProductBean bean);
	List<ProductBean> getALLInfo();
	ProductBean getProductDetails(String productName);
}
