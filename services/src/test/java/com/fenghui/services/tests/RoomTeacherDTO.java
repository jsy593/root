package com.fenghui.services.tests;

import java.io.Serializable;

import com.fenghui.bases.jpadtos.RoomUserDTO;
import com.fenghui.bases.jpadtos.TeacherDTO;

public class RoomTeacherDTO implements Serializable
{
	private static final long serialVersionUID = -7564790321276512091L;

	private TeacherDTO teacher;

	private RoomUserDTO roomUser;

	public TeacherDTO getTeacher()
	{
		return teacher;
	}

	public void setTeacher(TeacherDTO teacher)
	{
		this.teacher = teacher;
	}

	public RoomUserDTO getRoomUser()
	{
		return roomUser;
	}

	public void setRoomUser(RoomUserDTO roomUser)
	{
		this.roomUser = roomUser;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

}
