package com.fenghui.stockconsultant.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.fenghui.bases.handlejpa.ControllerBase;
import com.fenghui.bases.jpadtos.RoomDTO;
import com.fenghui.beans.webapp.TeacherBean;

@ManagedBean(name = "homeController")
@SessionScoped
public class HomeController extends ControllerBase implements Serializable
{
	private static final long serialVersionUID = 2653046380950652286L;

	private List<RoomDTO> roomList = null;
	private TeacherBean teacherBean = new TeacherBean();

	public HomeController()
	{
		roomList = teacherBean.roomList();
	}

	public List<RoomDTO> getRoomList()
	{
		return roomList;
	}

	public void setRoomList(List<RoomDTO> roomList)
	{
		this.roomList = roomList;
	}

}
