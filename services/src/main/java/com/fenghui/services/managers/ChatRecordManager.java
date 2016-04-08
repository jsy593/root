package com.fenghui.services.managers;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.ChatRecordDAO;
import com.fenghui.bases.jpaentities.ChatRecord;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.ChatRecordService;

public class ChatRecordManager implements ChatRecordService
{

	protected IHandleEntity<ChatRecord> handleChatRecord;

	EntityManager entityManager;

	private final String JPQL_FIND_CHATRECORD = "select e from ChatRecord e where e.id=:id";
	private final String JPQL_LIST_CHATRECORD = "select e from ChatRecord e";

	public ChatRecordManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	
	@Override
	@Transactional
	public boolean addChatRecord(ChatRecord chatRecord)
	{
		handleChatRecord = new ChatRecordDAO(entityManager);
		chatRecord.setChatTime(new Date());
		handleChatRecord.addEntity(chatRecord);
		handleChatRecord.close();
		return true;
	}

	@Override
	@Transactional
	public boolean cancelChatRecord(ChatRecord chatRecord)
	{
		handleChatRecord = new ChatRecordDAO(entityManager);
		handleChatRecord.deleteEntity(chatRecord);
		handleChatRecord.close();
		return true;
	}

	@Override
	@Transactional
	public boolean modifyChatRecord(ChatRecord chatRecord)
	{
		handleChatRecord = new ChatRecordDAO(entityManager);
		handleChatRecord.modifyEntity(chatRecord);
		handleChatRecord.close();
		return true;
	}
	@SuppressWarnings("unchecked")
	@Override
	public ChatRecord findChatRecord(ChatRecord chatRecord)
	{

		Query query = entityManager.createQuery(JPQL_FIND_CHATRECORD);
		query.setParameter("id", chatRecord.getId());
		List<ChatRecord> chatRecords = query.getResultList();
		if (chatRecords.size() == 0)
		{
			return null;
		}
		else
		{
			return (ChatRecord) chatRecords.get(0);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ChatRecord> listChatRecord()
	{
		Query query = entityManager.createQuery(JPQL_LIST_CHATRECORD);
		List<ChatRecord> chatRecord = query.getResultList();

		return chatRecord;
	}
		
}
