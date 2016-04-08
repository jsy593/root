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
@Table(name = "CHAT_RECORDS")
public class ChatRecord implements Serializable
{
	private static final long serialVersionUID = 70449021317553908L;

	public ChatRecord()
	{

	}

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "ROOM")
	private int roomId;

	@Column(name = "USER")
	private int userId;

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

	public int getRoomId()
	{
		return roomId;
	}

	public void setRoomId(int roomId)
	{
		this.roomId = roomId;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
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
