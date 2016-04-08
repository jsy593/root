package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.ChatRecord;

public class ChatRecordDAO extends CHandleJPAEntity<ChatRecord>
{
	public ChatRecordDAO(EntityManager entityManager)
	{
		super(entityManager);
	}
}
