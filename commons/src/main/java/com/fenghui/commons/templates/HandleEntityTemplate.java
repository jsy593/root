package com.fenghui.commons.templates;

import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.commons.utils.Constants;
import com.fenghui.commons.utils.Utils;

public abstract class HandleEntityTemplate<T> implements IHandleEntity<T>
{
	protected abstract boolean handleEntity(T t, int actionCode);
	protected abstract T queryEntity(T t);
	
	@Override
	public boolean addEntity(T t)
	{
		System.out.println(Utils.objectToJsonByJackson(t));
		return handleEntity(t, Constants.INSERTDATA);
	}

	@Override
	public boolean deleteEntity(T t)
	{
		return handleEntity(t, Constants.DELETEDATA);
	}

	@Override
	public boolean modifyEntity(T t)
	{
		return handleEntity(t, Constants.UPDATEDATA);
	}

	@Override
	public T getEntity(T t)
	{
		return queryEntity(t);
	}
}
