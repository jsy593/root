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
@Table(name = "PRODUCTS")
public class Product implements Serializable
{

	private static final long serialVersionUID = -2344278140857303240L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PORTAL")
	private String portal;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "CREATE_TIME", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	@Column(name = "LAST_MODIFIED_TIME", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedTime;

	@Column(name = "IS_DELETED")
	private Boolean isDeleted;

	public Product(int id, String name, String portal, String description, Date createTime, Date lastModifiedTime,
			Boolean isDeleted)
	{
		super();
		this.id = id;
		this.name = name;
		this.portal = portal;
		this.description = description;
		this.createTime = createTime;
		this.lastModifiedTime = lastModifiedTime;
		this.isDeleted = isDeleted;
	}

	public Product()
	{
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPortal()
	{
		return portal;
	}

	public void setPortal(String portal)
	{
		this.portal = portal;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
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

	public Boolean getIsDeleted()
	{
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted)
	{
		this.isDeleted = isDeleted;
	}

}
