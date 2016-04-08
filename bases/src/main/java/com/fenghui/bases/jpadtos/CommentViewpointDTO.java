package com.fenghui.bases.jpadtos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "COMMENTS_VIEWPOINT")
public class CommentViewpointDTO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4411883000952470344L;

	public CommentViewpointDTO()
	{
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@ManyToOne(cascade =
	{ CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "USER")	
	private UserDTO userDTO;

	@ManyToOne(cascade =
	{ CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "VIEWPOINT")
	private ViewpointDTO viewpointDTO;
	
	@Column(name = "CONTENT")
	private String content;

	@Column(name = "ADDED_TIME")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date addedTime;
	
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

	public UserDTO getUserDTO()
	{
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO)
	{
		this.userDTO = userDTO;
	}

	public ViewpointDTO getViewpointsDTO()
	{
		return viewpointDTO;
	}

	public void setViewpointsDTO(ViewpointDTO viewpointDTO)
	{
		this.viewpointDTO = viewpointDTO;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public Date getAddedTime()
	{
		return addedTime;
	}

	public void setAddedTime(Date addedTime)
	{
		this.addedTime = addedTime;
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
