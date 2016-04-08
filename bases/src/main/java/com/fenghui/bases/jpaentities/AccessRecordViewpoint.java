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
@Table(name = "ACCESS_RECORDS_VIEWPOINT")
public class AccessRecordViewpoint implements Serializable
{

	private static final long serialVersionUID = -1125234852152992764L;

	public AccessRecordViewpoint()
	{
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "USER")
	private int userId;

	@Column(name = "VIEWPOINT")
	private int viewpointId;

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

	public int getViewpointId()
	{
		return viewpointId;
	}

	public void setViewpointId(int viewpointId)
	{
		this.viewpointId = viewpointId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
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
