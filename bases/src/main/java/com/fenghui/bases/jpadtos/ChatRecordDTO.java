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
@Table(name = "CHAT_RECORDS")
public class ChatRecordDTO implements Serializable
{
	private static final long serialVersionUID = 5961047785430125432L;

	public ChatRecordDTO()
	{
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@ManyToOne(cascade =
	{ CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "ROOM")
	private RoomDTO roomDTO;

	@ManyToOne(cascade =
	{ CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "USER")
	private UserDTO userDTO;

	@Column(name = "CHAT_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date chatTime;

	@Column(name = "CONTENT")
	private String content;

	@Column(name = "IS_TEACHER")
	private int isTeacher;

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

	public UserDTO getUserDTO()
	{
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO)
	{
		this.userDTO = userDTO;
	}

	public Date getChatTime()
	{
		return chatTime;
	}

	public void setChatTime(Date chatTime)
	{
		this.chatTime = chatTime;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public int getIsTeacher()
	{
		return isTeacher;
	}

	public void setIsTeacher(int isTeacher)
	{
		this.isTeacher = isTeacher;
	}

}
