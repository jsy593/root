package com.fenghui.framework.services;

import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpaentities.InformationRoom;

public interface InformationRoomService
{
	@Transactional
	public boolean addInformationRoom(InformationRoom informationRoom);

	@Transactional
	public boolean modifyInformationRoom(InformationRoom informationRoom);

	@Transactional
	public boolean removeInformationRoom(InformationRoom informationRoom);

	public InformationRoom findInformationRoom(InformationRoom informationRoom);

	public List<InformationRoom> listInformationRoom();
	
}
