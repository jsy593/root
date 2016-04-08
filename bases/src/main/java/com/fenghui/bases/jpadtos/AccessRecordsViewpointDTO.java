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
@Table(name = "ACCESS_RECORDS_VIEWPOINT")
public class AccessRecordsViewpointDTO implements Serializable
{
	private static final long serialVersionUID = -1311076457762227145L;

	public AccessRecordsViewpointDTO()
	{

	}

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@ManyToOne(cascade =
	{ CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "USERS")
	private UserDTO userDTO;

	@ManyToOne(cascade =
	{ CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "VIEWPOINT")
	private ViewpointDTO viewpointDTO;

	@Column(name = "ACCESSINGTIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date accessingTime;

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

	public ViewpointDTO getViewpointDTO()
	{
		return viewpointDTO;
	}

	public void setViewpointDTO(ViewpointDTO viewpointDTO)
	{
		this.viewpointDTO = viewpointDTO;
	}

	public Date getAccessingTime()
	{
		return accessingTime;
	}

	public void setAccessingTime(Date accessingTime)
	{
		this.accessingTime = accessingTime;
	}

	
}
