package com.fenghui.bases.handlejpa;

import javax.persistence.EntityManager;

public class BeanBase
{
	private EntityManager entityManager;

	protected EntityManager getEntityManager()
	{
		if(entityManager == null)
			entityManager = SingleThreadJPAEntityManagerHolder.getEntityManager();
		
		return entityManager;
	}
}