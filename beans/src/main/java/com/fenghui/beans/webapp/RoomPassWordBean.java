package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.List;

import com.fenghui.bases.jpaentities.RoomPassWord;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.RoomPassWordService;
import com.fenghui.services.managers.RoomPassWordManager;

public class RoomPassWordBean extends BeanBase implements Serializable
{

	private static final long serialVersionUID = 1973157489297875986L;
	
	public boolean addRoomPassWord(RoomPassWord roomPassWord)
	{
		RoomPassWordService roomPassWordService = getProxyRoomPassWordManagerService();
		roomPassWordService.addRoomPassWord(roomPassWord);
		return true;
	}
	
	public boolean cancelRoomPassWord(RoomPassWord roomPassWord)
	{
		RoomPassWordService roomPassWordService = getProxyRoomPassWordManagerService();
		roomPassWord =findRoomPassWord(roomPassWord);
		return roomPassWordService.cancelRoomPassWord(roomPassWord);
	}
	
	public boolean modifyRoomPassWord(RoomPassWord roomPassWord)
	{
		RoomPassWordService roomPassWordService = getProxyRoomPassWordManagerService();
		roomPassWord =findRoomPassWord(roomPassWord);
		return roomPassWordService.modifyRoomPassWord(roomPassWord);
	}
	
	public RoomPassWord findRoomPassWord(RoomPassWord roomPassWord)
	{
		RoomPassWordService roomPassWordService = getProxyRoomPassWordManagerService();
		return roomPassWordService.findRoomPassWord(roomPassWord);
	}

	public List<RoomPassWord> listRoomPassWord()
	{
		RoomPassWordService roomPassWordService = getProxyRoomPassWordManagerService();
		return roomPassWordService.listRoomPassWord();
	}
	
	
	private RoomPassWordService getProxyRoomPassWordManagerService()
	{
		RoomPassWordService RoomPassWordManager = new RoomPassWordManager(entityManager);
		RoomPassWordService RoomPassWordServiceProxy = (RoomPassWordService) (jpaTransactionalProxyManager).proxyFor(RoomPassWordManager);
		return RoomPassWordServiceProxy;
	}

}
