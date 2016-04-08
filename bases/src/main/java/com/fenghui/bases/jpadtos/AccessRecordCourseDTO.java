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
@Table(name = "ACCESS_RECORDS_COURSE")
public class AccessRecordCourseDTO implements Serializable
{
	private static final long serialVersionUID = -9092535412890566760L;

	public AccessRecordCourseDTO()
	{

	}

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@ManyToOne(cascade =
	{ CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "USER")
	private UserDTO UserDTO;

	@ManyToOne(cascade =
	{ CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "COURSE")
	private CourseDTO coursesDTO;

	@Column(name = "ACCESSING_TIME")
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
		return UserDTO;
	}

	public void setUserDTO(UserDTO userDTO)
	{
		UserDTO = userDTO;
	}

	public CourseDTO getCoursesDTO()
	{
		return coursesDTO;
	}

	public void setCoursesDTO(CourseDTO coursesDTO)
	{
		this.coursesDTO = coursesDTO;
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
