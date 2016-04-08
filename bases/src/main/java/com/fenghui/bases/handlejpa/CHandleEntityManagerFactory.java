package com.fenghui.bases.handlejpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CHandleEntityManagerFactory
{
	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManagerFactory getEntityManagerFactory()
	{
		if(entityManagerFactory == null)
		{
			entityManagerFactory = Persistence.createEntityManagerFactory("eclipselink");
		}
		
		return entityManagerFactory;
	}
	
	private CHandleEntityManagerFactory()
	{
	}
}
