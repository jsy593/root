package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.List;

import com.fenghui.bases.jpaentities.InformationRoom;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.InformationRoomService;
import com.fenghui.services.managers.InformationRoomManager;

public class InformationRoomBean extends BeanBase implements Serializable
{
	private static final long serialVersionUID = 7657173335470041952L;

	public boolean addInformationRoom(InformationRoom informationRoom)
	{
		InformationRoomService informationRoomService = getProxyInformationRoomService();
		informationRoomService.addInformationRoom(informationRoom);
		return true;
	}

	public boolean modifyInformationRoom(InformationRoom informationRoom)
	{
		InformationRoomService informationRoomService = getProxyInformationRoomService();
		return informationRoomService.modifyInformationRoom(informationRoom);
	}

	public boolean removeInformationRoom(InformationRoom informationRoom)
	{
		InformationRoomService informationRoomService = getProxyInformationRoomService();
		return informationRoomService.removeInformationRoom(informationRoom);
	}

	public InformationRoom findInformationRoom(InformationRoom informationRoom)
	{
		InformationRoomService informationRoomService = getProxyInformationRoomService();
		return informationRoomService.findInformationRoom(informationRoom);
	}

	public List<InformationRoom> listInformationRooms()
	{
		InformationRoomService informationRoomService = getProxyInformationRoomService();
		return informationRoomService.listInformationRoom();
	}

	private InformationRoomService getProxyInformationRoomService()
	{
		InformationRoomService informationRoomManager = new InformationRoomManager(entityManager);
		InformationRoomService informationRoomServiceProxy = (InformationRoomService) (jpaTransactionalProxyManager)
				.proxyFor(informationRoomManager);

		return informationRoomServiceProxy;
	}
}
