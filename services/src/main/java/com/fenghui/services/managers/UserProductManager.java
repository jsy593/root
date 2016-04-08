package com.fenghui.services.managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.UserProductDAO;
import com.fenghui.bases.jpaentities.UserProduct;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.UserProductService;

public class UserProductManager implements UserProductService
{
	protected IHandleEntity<UserProduct> handleUserProduct;

	EntityManager entityManager;
	
	private final String JPQL_FIND_USERPRODUCT = "select e from USERSPRODUCTS e where e.userId=:userId";
	private final String JPQL_LIST_USERPRODUCT = "select e from USERSPRODUCTS e";

	public UserProductManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public boolean addUserProduct(UserProduct userProduct)
	{
		handleUserProduct = new UserProductDAO(entityManager);
		handleUserProduct.addEntity(userProduct);
		handleUserProduct.close();
		return true;
	}

	@Override
	@Transactional
	public boolean removeUserProduct(UserProduct usersProduct)
	{
		handleUserProduct = new UserProductDAO(entityManager);
		handleUserProduct.deleteEntity(usersProduct);
		handleUserProduct.close();
		return true;
	}

	@Override
	public boolean modifyUserProduct(UserProduct usersProduct)
	{
		handleUserProduct = new UserProductDAO(entityManager);
		handleUserProduct.modifyEntity(usersProduct);
		handleUserProduct.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserProduct findUserProduct(UserProduct userProduct)
	{
		Query query = entityManager.createQuery(JPQL_FIND_USERPRODUCT);
//		query.setParameter("userName", usersProducts.getUserName());
		List<UserProduct> listusersProducts = query.getResultList();
		return listusersProducts.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserProduct> listUserProduct()
	{
		Query query = entityManager.createQuery(JPQL_LIST_USERPRODUCT);
		List<UserProduct> listUserProduct = query.getResultList();
		return listUserProduct;
	}

}
