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
@Table(name = "ROOMS_USERS")
public class RoomUser implements Serializable
{
	
	private static final long serialVersionUID = -2622179155540107234L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "USER")
	private int userId;

	@Column(name = "ROOM")
	private int roomId;

	@Column(name = "CREATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	@Column(name = "LAST_MODIFIED_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedTime;

	@Column(name = "IS_DELETED")
	private boolean isDelete;

	public RoomUser()
	{
	}

	public RoomUser(int id, int userId, int roomId, Date createTime, Date lastModifiedTime, boolean isDelete)
	{
		super();
		this.id = id;
		this.userId = userId;
		this.roomId = roomId;
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

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public int getRoomId()
	{
		return roomId;
	}

	public void setRoomId(int roomId)
	{
		this.roomId = roomId;
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
