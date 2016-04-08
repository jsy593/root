package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.RoomUser;

public class RoomUserDAO extends CHandleJPAEntity<RoomUser>
{

	public RoomUserDAO(EntityManager entityManager)
	{
		super(entityManager);
	}

}
