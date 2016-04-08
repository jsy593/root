package com.fenghui.services.managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.RoomPassWordDAO;
import com.fenghui.bases.jpaentities.RoomPassWord;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.RoomPassWordService;

public class RoomPassWordManager implements RoomPassWordService
{
	
	protected IHandleEntity<RoomPassWord> handleRoomPassWord;

	EntityManager entityManager;
	
	private final String JPQL_FIND_ROOMPASSWORD = "select e from RoomPassWord e where e.id=:id";
	private final String JPQL_LIST_ROOMPASSWORD = "select e from RoomPassWord e";

	public RoomPassWordManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}


	@Override
	@Transactional
	public boolean addRoomPassWord(RoomPassWord roomPassWord)
	{
		handleRoomPassWord = new RoomPassWordDAO(entityManager);
		handleRoomPassWord.addEntity(roomPassWord);
		handleRoomPassWord.close();
		return true;
	}

	@Override
	@Transactional
	public boolean cancelRoomPassWord(RoomPassWord roomPassWord)
	{
		handleRoomPassWord = new RoomPassWordDAO(entityManager);
		handleRoomPassWord.deleteEntity(roomPassWord);
		handleRoomPassWord.close();
		return true;
	}

	@Override
	@Transactional
	public boolean modifyRoomPassWord(RoomPassWord roomPassWord)
	{
		handleRoomPassWord = new RoomPassWordDAO(entityManager);
		handleRoomPassWord.modifyEntity(roomPassWord);
		handleRoomPassWord.close();
		return true;
	}
	@SuppressWarnings("unchecked")
	@Override
	public RoomPassWord findRoomPassWord(RoomPassWord roomPassWord)
	{
		Query query = entityManager.createQuery(JPQL_FIND_ROOMPASSWORD);
		query.setParameter("id", roomPassWord.getId());
		List<RoomPassWord> roomPassWords = query.getResultList();
		if (roomPassWords.size() == 0)
		{
			return null;
		}
		else
		{
			return (RoomPassWord) roomPassWords.get(0);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<RoomPassWord> listRoomPassWord()
	{
		Query query = entityManager.createQuery(JPQL_LIST_ROOMPASSWORD);
		List<RoomPassWord> roomPassWord = query.getResultList();
		return roomPassWord;
	}

}
