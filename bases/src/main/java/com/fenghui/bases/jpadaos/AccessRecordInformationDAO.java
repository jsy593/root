package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.AccessRecordInformation;

public class AccessRecordInformationDAO extends CHandleJPAEntity<AccessRecordInformation>
{
	public AccessRecordInformationDAO(EntityManager entityManager)
	{
		super(entityManager);
	}
}