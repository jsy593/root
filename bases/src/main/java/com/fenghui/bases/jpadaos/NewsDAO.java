package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.News;

public class NewsDAO extends CHandleJPAEntity<News>
{

	public NewsDAO(EntityManager entityManager)
	{
		super(entityManager);
	}

}
