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
@Table(name = "NEWS_TYPE")
public class NewsType implements Serializable
{
	private static final long serialVersionUID = -6594871069944702709L;

	@Id
	@Column(name = "ID",length=10)
	@GeneratedValue
	private int id;
	
	@Column(name = "News")
	private int newsId;
	
	@Column(name = "TYPE")
	private String type;

	@Column(name = "CREATE_TIME", nullable=true)
	@Temporal(TemporalType.TIMESTAMP) 
	private Date createTime;

	@Column(name = "LAST_MODIFIED_TIME", nullable=true)
	@Temporal(TemporalType.TIMESTAMP) 
	private Date lastModifiedTime;
	
	@Column(name = "IS_DELETED")
	private Boolean isDeleted;

	public NewsType()
	{
	}

	public NewsType(int id, int newsId, String type, Date createTime, Date lastModifiedTime, Boolean isDeleted)
	{
		super();
		this.id = id;
		this.newsId = newsId;
		this.type = type;
		this.createTime = createTime;
		this.lastModifiedTime = lastModifiedTime;
		this.isDeleted = isDeleted;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getNewsId()
	{
		return newsId;
	}

	public void setNewsId(int newsId)
	{
		this.newsId = newsId;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
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

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
	
}
