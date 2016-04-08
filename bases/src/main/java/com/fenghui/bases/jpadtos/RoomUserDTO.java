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
@Table(name = "ROOMS_USERS")
public class RoomUserDTO implements Serializable
{
	private static final long serialVersionUID = 7564585931172173466L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@ManyToOne(cascade =
	{ CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "USER")
	private UserDTO user;

	@ManyToOne(cascade =
	{ CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "ROOM")
	private RoomDTO room;

	@Column(name = "CREATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	@Column(name = "LAST_MODIFIED_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedTime;

	@Column(name = "IS_DELETED")
	private boolean isDelete;

	public RoomUserDTO()
	{
	}

	public RoomUserDTO(int id, Date createTime, Date lastModifiedTime, boolean isDelete)
	{
		super();
		this.id = id;
		this.createTime = createTime;
		this.lastModifiedTime = lastModifiedTime;
		this.isDelete = isDelete;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public UserDTO getUser()
	{
		return user;
	}

	public void setUser(UserDTO user)
	{
		this.user = user;
	}

	public RoomDTO getRoom()
	{
		return room;
	}

	public void setRoom(RoomDTO room)
	{
		this.room = room;
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
