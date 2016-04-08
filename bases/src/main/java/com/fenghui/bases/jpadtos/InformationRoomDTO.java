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
@Table(name = "INFORMATION_ROOM")
public class InformationRoomDTO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7508181553680419005L;

	public InformationRoomDTO()
	{
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@OneToOne(cascade =
	{ CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "ROOM")
	private RoomDTO roomDTO;

	@OneToOne(cascade =
	{ CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "INFORMATION")
	private InformationRoomDTO informationRoomDTO;

	@Column(name = "IS_ENABLED")
	private int isEnabled;
	
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

	

	public RoomDTO getRoomDTO()
	{
		return roomDTO;
	}

	public void setRoomDTO(RoomDTO roomDTO)
	{
		this.roomDTO = roomDTO;
	}

	public InformationRoomDTO getInformationRoomDTO()
	{
		return informationRoomDTO;
	}

	public void setInformationRoomDTO(InformationRoomDTO informationRoomDTO)
	{
		this.informationRoomDTO = informationRoomDTO;
	}

	public int getIsEnabled()
	{
		return isEnabled;
	}

	public void setIsEnabled(int isEnabled)
	{
		this.isEnabled = isEnabled;
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
