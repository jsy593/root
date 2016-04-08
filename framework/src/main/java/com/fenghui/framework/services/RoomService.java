package com.fenghui.framework.services;

import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadtos.RoomDTO;
import com.fenghui.bases.jpaentities.Room;

public interface RoomService
{

	@Transactional
	public boolean addRoom(Room room);
	
	@Transactional
	public boolean cancelRoom(Room room);
	
	@Transactional
	public boolean modifyRoom(Room room);
	
	public Room findRoom(Room room);
	
	public List<Room> listRoom();
	
	public List<RoomDTO> listRoomDTO();
}
