package com.fenghui.bases.jpadtos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TeacherOtherLinksDTO
 *
 */
@Entity
@Table(name = "TEACHER_OTHER_LINKS")
public class TeacherOtherLinkDTO implements Serializable
{

	private static final long serialVersionUID = 2423106818434858146L;

	public TeacherOtherLinkDTO()
	{
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@ManyToOne(cascade =
	{ CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "TEACHER")
	private TeacherDTO teachersDTO;

	@Column(name = "URL")
	private String url;

	@Column(name = "CREATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	@Column(name = "LAST_MODIFIED_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedTime;

	@Column(name = "IS_DELETED")
	private boolean isDeleted;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public TeacherDTO getTeachersDTO()
	{
		return teachersDTO;
	}

	public void setTeachersDTO(TeacherDTO teachersDTO)
	{
		this.teachersDTO = teachersDTO;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
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

	public boolean isDeleted()
	{
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted)
	{
		this.isDeleted = isDeleted;
	}

}
