package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.PublishedChatRecord;

public class PublishedChatRecordDAO extends CHandleJPAEntity<PublishedChatRecord>
{

	public PublishedChatRecordDAO(EntityManager entityManager)
	{
		super(entityManager);
	}

}
