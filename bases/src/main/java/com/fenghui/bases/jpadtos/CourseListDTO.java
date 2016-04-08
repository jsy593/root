package com.fenghui.bases.jpadtos;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class CourseListDTO implements Serializable
{
	private static final long serialVersionUID = -7281228594551813649L;

	public CourseListDTO()
	{

	}

	public CourseListDTO(String title, int isCharged, float price, String coverpageLocation, Object number)
	{
		super();
		this.title = title;
		this.isCharged = isCharged;
		this.price = price;
		this.number = number;
		this.coverpageLocation = coverpageLocation;
	}

	private String title;

	private int isCharged;

	private float price;

	private Object number;

	private String coverpageLocation;

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public int getIsCharged()
	{
		return isCharged;
	}

	public void setIsCharged(int isCharged)
	{
		this.isCharged = isCharged;
	}

	public int isCharged()
	{
		return isCharged;
	}

	public void setCharged(int isCharged)
	{
		this.isCharged = isCharged;
	}

	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}

	

	public Object getNumber()
	{
		return number;
	}

	public void setNumber(Object number)
	{
		this.number = number;
	}

	public String getCoverpageLocation()
	{
		return coverpageLocation;
	}

	public void setCoverpageLocation(String coverpageLocation)
	{
		this.coverpageLocation = coverpageLocation;
	}

}
