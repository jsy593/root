package com.fenghui.bases.handlejpa;

import javax.persistence.EntityManager;

public class ManagerBase
{
	private EntityManager entityManager;

	protected EntityManager getEntityManager()
	{
		if((entityManager == null) || (!entityManager.isOpen()))
			entityManager = SingleThreadJPAEntityManagerHolder.getEntityManager();
		
		return entityManager;
	}
}
