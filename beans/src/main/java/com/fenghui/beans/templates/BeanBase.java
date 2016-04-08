package com.fenghui.beans.templates;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.JPATransactionManager;
import com.fenghui.bases.handlejpa.JPATransactionalProxyManager;
import com.fenghui.bases.handlejpa.SingleThreadJPAEntityManagerHolder;

public abstract class BeanBase
{
//	private EntityManager entityManager = null;
//	private JPATransactionManager jpaTransactionManager = null;
//	private JPATransactionalProxyManager jpaTransactionalProxyManager = null;
//
//	protected EntityManager getEntityManager()
//	{
//		if(entityManager == null)
//			SingleThreadJPAEntityManagerHolder.getEntityManager();
//		
//		return entityManager;
//	}
//	
//	
//	protected JPATransactionManager getJPATransactionManager()
//	{
//		if(jpaTransactionManager == null)
//			jpaTransactionManager = new JPATransactionManager(getEntityManager());
//		
//		return jpaTransactionManager;
//	}
//	
//	
//	protected JPATransactionalProxyManager getJPATransactionalProxyManager()
//	{
//		if(jpaTransactionalProxyManager == null)
//			jpaTransactionalProxyManager = new JPATransactionalProxyManager(getJPATransactionManager());
//		
//		return jpaTransactionalProxyManager;
//	}
//	
//	
	protected EntityManager entityManager = SingleThreadJPAEntityManagerHolder.getEntityManager();
	protected JPATransactionManager jpaTransactionManager = new JPATransactionManager(entityManager);
	protected JPATransactionalProxyManager jpaTransactionalProxyManager = new JPATransactionalProxyManager(jpaTransactionManager);
}
