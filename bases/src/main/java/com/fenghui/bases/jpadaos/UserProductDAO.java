package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.UserProduct;

public class UserProductDAO extends CHandleJPAEntity<UserProduct>
{

	public UserProductDAO(EntityManager entityManager)
	{
		super(entityManager);
	}

}
