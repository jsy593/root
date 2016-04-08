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
@Table(name = "ACCESS_RECORDS_INFORMATION")
public class AccessRecordInformationDTO implements Serializable
{

	private static final long serialVersionUID = -7208384205658764796L;

	public AccessRecordInformationDTO()
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
	@JoinColumn(name = "INFORMATION")
	private InformationDTO informationsDTO;

	@Column(name = "ACCESSING_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date accessingTime;

	public void setId(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

	public UserDTO getUserDTO()
	{
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO)
	{
		this.userDTO = userDTO;
	}

	public InformationDTO getInformationsDTO()
	{
		return informationsDTO;
	}

	public void setInformationsDTO(InformationDTO informationsDTO)
	{
		this.informationsDTO = informationsDTO;
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
