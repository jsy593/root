package com.fenghui.services.managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.InformationRoomDAO;
import com.fenghui.bases.jpaentities.InformationRoom;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.InformationRoomService;

public class InformationRoomManager implements InformationRoomService
{
	protected IHandleEntity<InformationRoom> handleInformationRoom;

	EntityManager entityManager;

	private final String JPQL_FIND_INFORMATIONROOM = "select e from InformationRoom e where e.id=:id";
	private final String JPQL_FIND_INFORMATIONROOMS = "select e from InformationRoom e";

	public InformationRoomManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public boolean addInformationRoom(InformationRoom informationRoom)
	{
		handleInformationRoom = new InformationRoomDAO(entityManager);
		handleInformationRoom.addEntity(informationRoom);
		handleInformationRoom.close();
		return true;
	}

	@Override
	@Transactional
	public boolean modifyInformationRoom(InformationRoom informationRoom)
	{
		handleInformationRoom = new InformationRoomDAO(entityManager);
		handleInformationRoom.modifyEntity(informationRoom);
		handleInformationRoom.close();
		return false;
	}

	@Override
	@Transactional
	public boolean removeInformationRoom(InformationRoom informationRoom)
	{
		handleInformationRoom = new InformationRoomDAO(entityManager);
		handleInformationRoom.deleteEntity(informationRoom);
		handleInformationRoom.close();
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public InformationRoom findInformationRoom(InformationRoom informationRoom)
	{
		Query query = entityManager.createQuery(JPQL_FIND_INFORMATIONROOM);
		query.setParameter("id", informationRoom.getId());
		List<InformationRoom> InformationRooms = query.getResultList();

		if (InformationRooms.size() == 0)
		{
			return null;
		}
		else
		{
			return (InformationRoom) InformationRooms.get(0);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<InformationRoom> listInformationRoom()
	{
		Query query = entityManager.createQuery(JPQL_FIND_INFORMATIONROOMS);
		List<InformationRoom> InformationRooms = query.getResultList();

		return InformationRooms;
	}
}
