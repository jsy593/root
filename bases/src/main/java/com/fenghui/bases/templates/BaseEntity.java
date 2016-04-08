package com.fenghui.bases.templates;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class BaseEntity
{
	@Column(name = "CREATE_TIME")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date createTime;

	@Column(name = "LAST_MODIFIED_NAME")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date lastModifiedTime;

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
}
