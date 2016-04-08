package com.fenghui.services.managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.ProductDAO;
import com.fenghui.bases.jpaentities.Product;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.ProductsService;

public class ProductManager implements ProductsService
{
	protected IHandleEntity<Product> handleProducts;

	EntityManager entityManager;
	
	private final String JPQL_FIND_PRODUCTS = "select e from PRODUCTS e where e.userId=:userId";
	private final String JPQL_LIST_PRODUCTS = "select e from PRODUCTS e";

	public ProductManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public boolean addProducts(Product products)
	{
		handleProducts = new ProductDAO(entityManager);
		handleProducts.addEntity(products);
		handleProducts.close();
		return false;
	}

	@Override
	@Transactional
	public boolean removeProducts(Product products)
	{
		handleProducts = new ProductDAO(entityManager);
		handleProducts.deleteEntity(products);
		handleProducts.close();
		return false;
	}

	@Override
	@Transactional
	public boolean modifyProducts(Product products)
	{
		handleProducts = new ProductDAO(entityManager);
		handleProducts.modifyEntity(products);
		handleProducts.close();
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Product findProducts(Product products)
	{
		Query query = entityManager.createQuery(JPQL_FIND_PRODUCTS);
//		query.setParameter("userId", products.getUserId());
		List<Product> listProducts = query.getResultList();
		return listProducts.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listProducts()
	{
		Query query = entityManager.createQuery(JPQL_LIST_PRODUCTS);
		List<Product> listProducts = query.getResultList();
		return listProducts;
	}

}
