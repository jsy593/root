package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.AccessRecordViewpoint;

public class AccessRecordViewpointDAO extends CHandleJPAEntity<AccessRecordViewpoint>
{
	public AccessRecordViewpointDAO(EntityManager entityManager)
	{
		super(entityManager);
	}
}
