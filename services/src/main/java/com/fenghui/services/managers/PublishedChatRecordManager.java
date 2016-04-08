package com.fenghui.services.managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.PublishedChatRecordDAO;
import com.fenghui.bases.jpaentities.PublishedChatRecord;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.PublishedChatRecordsService;

public class PublishedChatRecordManager implements PublishedChatRecordsService
{

	protected IHandleEntity<PublishedChatRecord> handlePublishedChatRecords;

	EntityManager entityManager;
	
	private final String JPQL_FIND_PUBLISHEDCHATRECORDS = "select e from PublishedChatRecords e where e.id=:id";
	private final String JPQL_LIST_PUBLISHEDCHATRECORDS = "select e from PublishedChatRecords e";

	public PublishedChatRecordManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public boolean addPublishedChatRecords(PublishedChatRecord publishedChatRecords)
	{

		handlePublishedChatRecords = new PublishedChatRecordDAO(entityManager);
		handlePublishedChatRecords.addEntity(publishedChatRecords);
		handlePublishedChatRecords.close();
		return true;
	}

	@Override
	@Transactional
	public boolean cancelPublishedChatRecords(PublishedChatRecord publishedChatRecords)
	{
		handlePublishedChatRecords = new PublishedChatRecordDAO(entityManager);
		handlePublishedChatRecords.deleteEntity(publishedChatRecords);
		handlePublishedChatRecords.close();
		return true;
	}

	@Override
	@Transactional
	public boolean modifyPublishedChatRecords(PublishedChatRecord publishedChatRecords)
	{
		handlePublishedChatRecords = new PublishedChatRecordDAO(entityManager);
		handlePublishedChatRecords.modifyEntity(publishedChatRecords);
		handlePublishedChatRecords.close();
		return true;
	}
	@SuppressWarnings("unchecked")
	@Override
	public PublishedChatRecord findPublishedChatRecords(PublishedChatRecord publishedChatRecords)
	{

		Query query = entityManager.createQuery(JPQL_FIND_PUBLISHEDCHATRECORDS);
		query.setParameter("id", publishedChatRecords.getId());
		List<PublishedChatRecord> publishedChatRecord = query.getResultList();
		if (publishedChatRecord.size() == 0)
		{
			return null;
		}
		else
		{
			return (PublishedChatRecord) publishedChatRecord.get(0);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PublishedChatRecord> listPublishedChatRecords()
	{
		Query query = entityManager.createQuery(JPQL_LIST_PUBLISHEDCHATRECORDS);
		List<PublishedChatRecord> publishedChatRecords = query.getResultList();

		return publishedChatRecords;
	}

}
