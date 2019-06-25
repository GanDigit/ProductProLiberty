package com.productpro.productapi.jpa;

import java.util.List;
import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.productpro.productapi.model.Product;
import com.productpro.productapi.util.LogUtil;

@ApplicationScoped
public class ProductJPA {

	private static EntityManager entityManager = Persistence.createEntityManagerFactory("JPACriteriaBuilder").createEntityManager();	

	public static Product find(int id) {
		Product product = entityManager.find(Product.class, id);
		return product;
	}

	public static List<Product> findAll() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Product> from = criteriaQuery.from(Product.class);
		CriteriaQuery<Object> selectQuery = criteriaQuery.select(from);
		TypedQuery<Object> typedQuery = entityManager.createQuery(selectQuery);

		List<Object> productList = typedQuery.getResultList();

		List<Product> resultList = new ArrayList<Product>();;
		Product product;
		if(productList != null && productList.size() > 0) {
			for(Object object : productList) {
				product = (Product)object;
				resultList.add(product);
				LogUtil.log(product.toString());
			}
		}
		
		LogUtil.log("Product count : " + productList.size());
		return resultList;
	}

	public Product create(Product product) {
		entityManager.getTransaction().begin();
		entityManager.persist(product);
		entityManager.getTransaction().commit();
		return product;
	}

	public Product update(Product product) {
		entityManager.getTransaction().begin();
		entityManager.persist(product);
		entityManager.getTransaction().commit();
		
		product = find(product.getId());
		
		return product;
	}

	public boolean delete(int id) {
		Product product = find(id);

		entityManager.getTransaction().begin();
		entityManager.remove(product);
		entityManager.getTransaction().commit();
		return true;
	}
}