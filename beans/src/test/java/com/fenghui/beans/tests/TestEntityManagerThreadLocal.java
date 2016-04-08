package com.fenghui.beans.tests;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.SingleThreadJPAEntityManagerHolder;

public class TestEntityManagerThreadLocal implements Runnable
{
	public static void main(String[] args)
	{
		TestEntityManagerThreadLocal testEntityManagerThreadLocal = new TestEntityManagerThreadLocal();
        Thread t1 = new Thread(testEntityManagerThreadLocal, "a");
        Thread t2 = new Thread(testEntityManagerThreadLocal, "b");
        t1.start();
        t2.start();	}

	@Override
	public void run()
	{
		queryDB();
	}
	
	public void queryDB()
	{
		EntityManager entityManager = SingleThreadJPAEntityManagerHolder.getEntityManager();
		System.out.println(Thread.currentThread().getName() + " is running ");
		System.out.println(entityManager.toString());
		entityManager.close();
		System.out.println(entityManager.isOpen());
	}
}
