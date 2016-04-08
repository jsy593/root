package com.fenghui.bases.handlejpa;

import javax.persistence.EntityManager;

public abstract class ControllerBase extends ManagerBase
{
	protected EntityManager entityManager = getEntityManager();
	protected JPATransactionManager jpaTransactionManager = new JPATransactionManager(entityManager);
	protected JPATransactionalProxyManager jpaTransactionalProxyManager = new JPATransactionalProxyManager(jpaTransactionManager);
}