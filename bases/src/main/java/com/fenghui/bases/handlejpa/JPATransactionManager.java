package com.fenghui.bases.handlejpa;

import javax.persistence.EntityManager;

public class JPATransactionManager
{
	EntityManager entityManager = null;

	public JPATransactionManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	public final void start()
	{
		entityManager.getTransaction().begin();
	}

	public final void commit()
	{
		entityManager.getTransaction().commit();
	}

	public final void rollback()
	{
		entityManager.getTransaction().rollback();
	}
}
