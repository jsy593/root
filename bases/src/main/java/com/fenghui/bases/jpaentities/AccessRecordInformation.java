package com.fenghui.bases.jpaentities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ACCESS_RECORDS_INFORMATION")
public class AccessRecordInformation implements Serializable
{

	private static final long serialVersionUID = -6678582223173085854L;

	public AccessRecordInformation()
	{

	}

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "USER")
	private int userId;

	@Column(name = "INFORMATION")
	private int informationId;

	@Column(name = "ACCESSING_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date accessingTime;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public int getInformationId()
	{
		return informationId;
	}

	public void setInformationId(int informationId)
	{
		this.informationId = informationId;
	}

	public Date getAccessingTime()
	{
		return accessingTime;
	}

	public void setAccessingTime(Date accessingTime)
	{
		this.accessingTime = accessingTime;
	}

}
