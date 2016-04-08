package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.NewsType;

public class NewsTypeDAO extends CHandleJPAEntity<NewsType>
{

	public NewsTypeDAO(EntityManager entityManager)
	{
		super(entityManager);
	}

}
