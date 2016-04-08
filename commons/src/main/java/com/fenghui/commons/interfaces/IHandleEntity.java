package com.fenghui.commons.interfaces;

public interface IHandleEntity<T>
{
	public boolean addEntity(T t);
	public boolean deleteEntity(T t);
	public boolean modifyEntity(T t);
	public T getEntity(T t);
	
	public void close();
}
