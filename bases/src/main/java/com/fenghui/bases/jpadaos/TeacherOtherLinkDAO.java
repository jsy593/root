package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.TeacherOtherLink;

public class TeacherOtherLinkDAO extends CHandleJPAEntity<TeacherOtherLink>
{

	public TeacherOtherLinkDAO(EntityManager entityManager)
	{
		super(entityManager);
	}

}
