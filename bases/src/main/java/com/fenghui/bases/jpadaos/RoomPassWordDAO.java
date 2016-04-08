package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.RoomPassWord;

public class RoomPassWordDAO extends CHandleJPAEntity<RoomPassWord>
{

	public RoomPassWordDAO(EntityManager entityManager)
	{
		super(entityManager);

	}

}
