package com.fenghui.bases.testresources;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.JPATransactionManager;
import com.fenghui.bases.handlejpa.JPATransactionalProxyManager;
import com.fenghui.bases.handlejpa.SingleThreadJPAEntityManagerHolder;

public class GetEntityResources {
	protected EntityManager entityManager = SingleThreadJPAEntityManagerHolder.getEntityManager();
	protected JPATransactionManager jpaTransactionManager = new JPATransactionManager(entityManager);
	protected JPATransactionalProxyManager jpaTransactionalProxyManager = new JPATransactionalProxyManager(jpaTransactionManager);
}
