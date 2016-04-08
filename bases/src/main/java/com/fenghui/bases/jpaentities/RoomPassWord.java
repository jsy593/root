package com.fenghui.bases.jpaentities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: RoomPassWOrd
 *
 */
@Entity
@Table(name = "ROOM_PASSWORD")
public class RoomPassWord implements Serializable
{

	private static final long serialVersionUID = -8491550044740594620L;

	public RoomPassWord()
	{

	}

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "ROOM")
	private int roomId;

	@Column(name = "ROOM_PASSWORD")
	private String roomPassWord;

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

	public String getRoomPassWord()
	{
		return roomPassWord;
	}

	public void setRoomPassWord(String roomPassWord)
	{
		this.roomPassWord = roomPassWord;
	}

}
