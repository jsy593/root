package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.Room;

public class RoomDAO extends CHandleJPAEntity<Room>
{

	public RoomDAO(EntityManager entityManager)
	{
		super(entityManager);
	}

}
