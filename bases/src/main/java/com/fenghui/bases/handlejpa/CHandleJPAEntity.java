package com.fenghui.bases.handlejpa;

import javax.persistence.EntityManager;

import com.fenghui.commons.templates.HandleEntityTemplate;
import com.fenghui.commons.utils.Constants;

public class CHandleJPAEntity<T> extends HandleEntityTemplate<T>
{
	protected EntityManager entityManager;

	public CHandleJPAEntity(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	
	@Override
	public void close()
	{
		
		
	}
	
	@Override
	protected boolean handleEntity(T t, int actionCode)
	{
		boolean isSuccess = false;

		if (entityManager == null)
			return isSuccess;

		switch (actionCode)
		{
			case Constants.INSERTDATA:
				isSuccess = addObject(t);
				break;

			case Constants.DELETEDATA:
				isSuccess = deleteObject(t);
				break;

			case Constants.UPDATEDATA:
				isSuccess = updateObject(t);
				break;
		}
		return isSuccess;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected T queryEntity(T t)
	{
		return (T) entityManager.find(t.getClass(), t);
	}

	private boolean addObject(T t)
	{
		if (t == null)
		{
			return false;
		}
		else
		{
			entityManager.persist(t);
			return true;
		}
	}

	private boolean deleteObject(T t)
	{
		if (t == null)
		{
			return false;
		}
		else
		{
			entityManager.remove(t);
			return true;
		}

	}

	private boolean updateObject(T t)
	{
		if (t == null)
		{
			return false;
		}
		else
		{
			entityManager.merge(t);
			return true;
		}
	}
}
