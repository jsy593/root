package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.InformationRoom;

public class InformationRoomDAO extends CHandleJPAEntity<InformationRoom>
{
	public InformationRoomDAO(EntityManager entityManager)
	{
		super(entityManager);
	}
}
