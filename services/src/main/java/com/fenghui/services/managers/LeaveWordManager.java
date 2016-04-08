package com.fenghui.services.managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.LeaveWordDAO;
import com.fenghui.bases.jpaentities.LeaveWord;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.LeaveWordService;

public class LeaveWordManager implements LeaveWordService
{
	protected IHandleEntity<LeaveWord> handleLeaveWord;

	EntityManager entityManager;
	
	private final String JPQL_FIND_LEAVEWORD = "select e from LEAVEWORDS e where e.ID=:userId";
	private final String JPQL_LIST_LEAVEWORD = "select e from LEAVEWORDS e";

	public LeaveWordManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public boolean addLeaveword(LeaveWord leaveword)
	{
		handleLeaveWord = new LeaveWordDAO(entityManager);
		handleLeaveWord.addEntity(leaveword);
		handleLeaveWord.close();
		return true;
		
		
	}

	@Override
	@Transactional
	public boolean removeLeaveword(LeaveWord leaveword)
	{
		handleLeaveWord = new LeaveWordDAO(entityManager);
		handleLeaveWord.addEntity(leaveword);
		handleLeaveWord.close();
		return true;
	}

	@Override
	@Transactional
	public boolean modifyLeaveword(LeaveWord leaveword)
	{
		handleLeaveWord = new LeaveWordDAO(entityManager);
		handleLeaveWord.addEntity(leaveword);
		handleLeaveWord.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public LeaveWord findLeaveword(LeaveWord leaveword)
	{
		Query query = entityManager.createQuery(JPQL_FIND_LEAVEWORD);
		query.setParameter("id", leaveword.getId());
		List<LeaveWord> listLeaveWords = query.getResultList();

			return (LeaveWord) listLeaveWords.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LeaveWord> listLeaveword()
	{
		Query query = entityManager.createQuery(JPQL_LIST_LEAVEWORD);
		List<LeaveWord> listLeaveWords = query.getResultList();
		return listLeaveWords;
	}

}
