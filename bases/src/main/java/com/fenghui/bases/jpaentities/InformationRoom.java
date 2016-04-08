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
@Table(name = "INFORMATION_ROOM")
public class InformationRoom implements Serializable
{
	private static final long serialVersionUID = -98568965428798449L;

	public InformationRoom()
	{
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "ROOM")
	private int roomsId;

	@Column(name = "INFORMATION")
	private int information;

	@Column(name = "IS_ENABLED")
	private int isEnabled;
	
	@Column(name = "CREATE_TIME")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date createTime;

	@Column(name = "LAST_MODIFIED_TIME")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date lastModifiedTime;

	@Column(name = "IS_DELETED")
	private boolean isDelete;
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getRoomsId()
	{
		return roomsId;
	}

	public void setRoomsId(int roomsId)
	{
		this.roomsId = roomsId;
	}

	public int getInformation()
	{
		return information;
	}

	public void setInformation(int information)
	{
		this.information = information;
	}

	public int getIsEnabled()
	{
		return isEnabled;
	}

	public void setIsEnabled(int isEnabled)
	{
		this.isEnabled = isEnabled;
	}

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public Date getLastModifiedTime()
	{
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime)
	{
		this.lastModifiedTime = lastModifiedTime;
	}

	public boolean isDelete()
	{
		return isDelete;
	}

	public void setDelete(boolean isDelete)
	{
		this.isDelete = isDelete;
	}

	
}
