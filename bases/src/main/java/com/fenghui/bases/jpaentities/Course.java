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
@Table(name = "COURSES")
public class Course implements Serializable
{
	private static final long serialVersionUID = 8393786048556104523L;

	public Course()
	{
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "TITLE")
	private String title;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "RELEASE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date releaseTime;
	
	@Column(name = "IS_CHARGED")
	private int isCharged;
	
	@Column(name = "PRICE")
	private float price;
	
	@Column(name = "ACCESSING_PORTAL")
	private String accessingPortal;
	
	@Column(name = "COVERPAGE_LOCATION")
	private String coverpageLocation;
	
	@Column(name = "OWNER")
	private int ownerId;
	
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

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Date getReleaseTime()
	{
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime)
	{
		this.releaseTime = releaseTime;
	}

	public int getIsCharged()
	{
		return isCharged;
	}

	public void setIsCharged(int isCharged)
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

	public String getAccessingPortal()
	{
		return accessingPortal;
	}

	public void setAccessingPortal(String accessingPortal)
	{
		this.accessingPortal = accessingPortal;
	}

	public String getCoverpageLocation()
	{
		return coverpageLocation;
	}

	public void setCoverpageLocation(String coverpageLocation)
	{
		this.coverpageLocation = coverpageLocation;
	}

	public int getOwnerId()
	{
		return ownerId;
	}

	public void setOwnerId(int ownerId)
	{
		this.ownerId = ownerId;
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
