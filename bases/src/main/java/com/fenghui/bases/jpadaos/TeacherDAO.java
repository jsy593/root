package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.Teacher;

public class TeacherDAO extends CHandleJPAEntity<Teacher>
{

	public TeacherDAO(EntityManager entityManager)
	{
		super(entityManager);
	}

}
