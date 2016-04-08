package com.fenghui.bases.jpadtos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "VIEWPOINTS")
public class ViewpointDTO implements Serializable
{
	
	private static final long serialVersionUID = -7322328340943630822L;

	public ViewpointDTO(){}
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "CONTENT")
	private String content;
	
	@Column(name = "RELEASE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date releaseTime;
	
	@Column(name = "IS_CHARGED")
	private int isCharged;
	
	@Column(name = "PRICE")
	private float price;
	
	@OneToOne(cascade =
	{ CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "OWNER")
	private TeacherDTO teacher;

	

	public TeacherDTO getTeacher()
	{
		return teacher;
	}

	public void setTeacher(TeacherDTO teacher)
	{
		this.teacher = teacher;
	}

	@Column(name = "CREATE_TIME")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date createTime;

	@Column(name = "LAST_MODIFIED_TIME")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date lastModifiedTime;
	
	@Column(name = "IS_DELETED")
	private Boolean isDeleted;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
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
