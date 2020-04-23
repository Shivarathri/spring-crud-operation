package com.capgemini.springangular.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.springangular.beans.ProductBean;
import com.capgemini.springangular.exception.ProductException;
@Repository
public class ProductDAOImp implements ProductDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;
	@Override
	public boolean updateProductInfo(ProductBean bean) {
		boolean isUpdated = false;
		EntityManager manager = factory.createEntityManager();
		ProductBean productPrimary = manager.find(ProductBean.class,bean.getProductName());
		if(productPrimary != null) {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();;
			//productPrimary.setProductName(info.getProductName());
			//productPrimary.setImageUrl(info.getImageUrl());
			productPrimary.setProductPrice(bean.getProductPrice());
			//productPrimary.setProductDescription(info.getProductDescription());
			transaction.commit();
			isUpdated = true;
		}
		manager.close();
		return isUpdated;
	}

	@Override
	public boolean deleteProductInfo(String productName) {
		boolean isDeleted = false;
		EntityManager manager = factory.createEntityManager();
		ProductBean productInfoBean = manager.find(ProductBean.class, productName);
		if (productInfoBean != null) {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(productInfoBean);
			transaction.commit();
			isDeleted=true;
		}
		manager.close();
		return isDeleted;
	}

	@Override
	public boolean createProductInfo(ProductBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			manager.persist(bean);
			transaction.commit();
			isAdded = true;
			System.out.println("Added");
		} catch (Exception e) {
			// TODO: handle exceptionentityClass
			e.printStackTrace();
			throw new ProductException("Product is already exists!");
		} finally {
			manager.close();
		}
		return isAdded;
	}

	@Override
	public List<ProductBean> getALLInfo() {
		EntityManager manager = factory.createEntityManager();
		String jpql = "Select p from ProductBean p";
		Query query = manager.createQuery(jpql);
		List<ProductBean> record = query.getResultList();
		return record;
	}

	@Override
	public ProductBean getProductDetails(String productName) {
		EntityManager manager = factory.createEntityManager();
		ProductBean productBean = manager.find(ProductBean.class, productName);
		manager.close();
		return productBean;
	}

}
