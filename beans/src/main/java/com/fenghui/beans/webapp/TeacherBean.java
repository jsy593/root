package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.List;

import com.fenghui.bases.jpadtos.RoomDTO;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.RoomService;
import com.fenghui.services.managers.RoomManager;

public class TeacherBean extends BeanBase implements Serializable
{

	private static final long serialVersionUID = 6310917381899326672L;
	
	public List<RoomDTO> roomList() {
		RoomService roomService = getProxyRoomService();
		return roomService.listRoomDTO();
	}
	
	private RoomService getProxyRoomService()
	{
		RoomService RoomManager = new RoomManager(entityManager);
		RoomService RoomServiceProxy = (RoomService) (jpaTransactionalProxyManager).proxyFor(RoomManager);
		return RoomServiceProxy;
	}

}
