package com.fenghui.services.managers;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.RoomDAO;
import com.fenghui.bases.jpadtos.RoomDTO;
import com.fenghui.bases.jpaentities.Room;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.RoomService;

public class RoomManager implements RoomService
{

	protected IHandleEntity<Room> handleRoom;

	EntityManager entityManager;

	private final String JPQL_FIND_ROOM = "select e from Room e where e.id=:id";
	private final String JPQL_LIST_ROOM = "select e from Room e";
	private final String JPQL_LIST_ROOMDTO = "select e from RoomDTO e";

	public RoomManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public boolean addRoom(Room room)
	{

		handleRoom = new RoomDAO(entityManager);
		room.setCreateTime(new Date());
		room.setLastModifiedTime(new Date());
		handleRoom.addEntity(room);
		handleRoom.close();
		return true;
	}

	@Override
	@Transactional
	public boolean cancelRoom(Room room)
	{
		handleRoom = new RoomDAO(entityManager);
		handleRoom.deleteEntity(room);
		handleRoom.close();
		return true;
	}

	@Override
	@Transactional
	public boolean modifyRoom(Room room)
	{
		handleRoom = new RoomDAO(entityManager);
		room.setLastModifiedTime(new Date());
		handleRoom.modifyEntity(room);
		handleRoom.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Room findRoom(Room room)
	{
		Query query = entityManager.createQuery(JPQL_FIND_ROOM);
		query.setParameter("id", room.getId());
		List<Room> rooms = query.getResultList();
		if (rooms.size() == 0)
		{
			return null;
		}
		else
		{
			return (Room) rooms.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Room> listRoom()
	{
		Query query = entityManager.createQuery(JPQL_LIST_ROOM);
		List<Room> room = query.getResultList();

		return room;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RoomDTO> listRoomDTO()
	{
		Query query = entityManager.createQuery(JPQL_LIST_ROOMDTO);
		List<RoomDTO> room = query.getResultList();

		return room;
	}

}
