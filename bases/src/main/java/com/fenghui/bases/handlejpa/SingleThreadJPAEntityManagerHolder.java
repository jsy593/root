package com.fenghui.bases.handlejpa;

import javax.persistence.EntityManager;

public class SingleThreadJPAEntityManagerHolder
{
	private static ThreadLocal<EntityManager> localEntityManager = new ThreadLocal<EntityManager>();

	public static EntityManager getEntityManager()
	{
		EntityManager entityManager = localEntityManager.get();
		if ((entityManager == null))
		{
			entityManager = CHandleEntityManagerFactory
					.getEntityManagerFactory().createEntityManager();
		}

		return entityManager;
	}

	public static void removeEntityManager()
	{
		localEntityManager.remove();
	}
}
