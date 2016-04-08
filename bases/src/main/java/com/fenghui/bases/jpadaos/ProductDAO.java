package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.Product;

public class ProductDAO extends CHandleJPAEntity<Product>
{

	public ProductDAO(EntityManager entityManager)
	{
		super(entityManager);
	}

}
