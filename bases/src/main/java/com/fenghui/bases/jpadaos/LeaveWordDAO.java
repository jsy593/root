package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.LeaveWord;

public class LeaveWordDAO extends CHandleJPAEntity<LeaveWord>
{
	public LeaveWordDAO(EntityManager entityManager)
	{
		super(entityManager);
	}
}
