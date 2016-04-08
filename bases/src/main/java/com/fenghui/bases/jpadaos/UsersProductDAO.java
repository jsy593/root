package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.UserProduct;

public class UsersProductDAO extends CHandleJPAEntity<UserProduct>
{

	public UsersProductDAO(EntityManager entityManager)
	{
		super(entityManager);
	}

}
