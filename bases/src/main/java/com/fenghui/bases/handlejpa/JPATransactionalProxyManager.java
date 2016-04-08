package com.fenghui.bases.handlejpa;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JPATransactionalProxyManager
{
	private JPATransactionManager jpaTransactionManager;

	public JPATransactionalProxyManager(JPATransactionManager jpaTransactionManager)
	{

		this.jpaTransactionManager = jpaTransactionManager;
	}

	public Object proxyFor(Object object)
	{
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new AnnotationTransactionInvocationHandler(object, jpaTransactionManager));
	}
}

class AnnotationTransactionInvocationHandler implements InvocationHandler
{
	private Object proxied;
	private JPATransactionManager jpaTransactionManager;

	AnnotationTransactionInvocationHandler(Object object, JPATransactionManager jpaTransactionManager)
	{
		this.proxied = object;
		this.jpaTransactionManager = jpaTransactionManager;
	}

	public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable
	{
		Method originalMethod = proxied.getClass().getMethod(method.getName(), method.getParameterTypes());

		Object result = null;

		if (!originalMethod.isAnnotationPresent(Transactional.class))
		{
			result = method.invoke(proxied, objects);
			return result;
		}

		jpaTransactionManager.start();
		
		try
		{
			result = method.invoke(proxied, objects);
			jpaTransactionManager.commit();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			jpaTransactionManager.rollback();
		}

		return result;
	}
}
