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
@Table(name = "NEWS")
public class News implements Serializable
{

	private static final long serialVersionUID = 8162875018692512139L;

	@Id
	@Column(name = "ID", length = 10)
	@GeneratedValue
	private int id;

	@Column(name = "TITLE", length = 40, nullable = false)
	private String title;

	@Column(name = "CONTENT", nullable = false)
	private String content;

	@Column(name = "AUTHOR", length = 40, nullable = true)
	private String author;
	
	@Column(name = "RELEASE_TIME", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date releaseTime;

	@Column(name = "ORIGINAL_SOURCE", length = 255, nullable = true)
	private String originalSource;

	@Column(name = "CREATE_TIME", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	@Column(name = "LAST_MODIFIED_TIME", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedTime;

	@Column(name = "IS_DELETED")
	private Boolean isDeleted;

	public News()
	{
	}

	public News(int id, String title, String content, String author, Date releaseTime,
			String originalSource, Date createTime, Date lastModifiedTime, Boolean isDeleted)
	{
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.releaseTime = releaseTime;
		this.originalSource = originalSource;
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

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public Date getReleaseTime()
	{
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime)
	{
		this.releaseTime = releaseTime;
	}

	public String getOriginalSource()
	{
		return originalSource;
	}

	public void setOriginalSource(String originalSource)
	{
		this.originalSource = originalSource;
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
