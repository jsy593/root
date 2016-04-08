package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.Information;

public class InformationDAO extends CHandleJPAEntity<Information>
{
	public InformationDAO(EntityManager entityManager)
	{
		super(entityManager);
	}
}
