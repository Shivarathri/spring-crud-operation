package com.capgemini.springangular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springangular.beans.ProductBean;
import com.capgemini.springangular.dao.ProductDAO;
@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	private ProductDAO dao;
	@Override
	public boolean updateProductInfo(ProductBean bean) {
		// TODO Auto-generated method stub
		return dao.updateProductInfo(bean);
	}

	@Override
	public boolean deleteProductInfo(String productName) {
		// TODO Auto-generated method stub
		return dao.deleteProductInfo(productName);
	}

	@Override
	public boolean createProductInfo(ProductBean bean) {
		// TODO Auto-generated method stub
		return dao.createProductInfo(bean);
	}

	@Override
	public List<ProductBean> getALLInfo() {
		// TODO Auto-generated method stub
		return dao.getALLInfo();
	}

	@Override
	public ProductBean getProductDetails(String productName) {
		// TODO Auto-generated method stub
		return dao.getProductDetails(productName);
	}

}
