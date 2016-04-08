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
@Table(name = "TEACHERS")
public class Teacher implements Serializable
{
	private static final long serialVersionUID = -2170054593026930792L;

	public Teacher()
	{
	}
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	
	@Column(name = "POSITION")
	private String position;
	
	@Column(name = "CERTIFICATE_NO")
	private String certificateNo;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "USER")
	private int userId;
	
	@Column(name = "PHOTO_LOCATION")
	private String photoLocation;
	
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

	public String getPosition()
	{
		return position;
	}

	public void setPosition(String position)
	{
		this.position = position;
	}

	public String getCertificateNo()
	{
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo)
	{
		this.certificateNo = certificateNo;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	
	{
		this.userId = userId;
	}

	public String getPhotoLocation()
	{
		return photoLocation;
	}

	public void setPhotoLocation(String photoLocation)
	{
		this.photoLocation = photoLocation;
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
