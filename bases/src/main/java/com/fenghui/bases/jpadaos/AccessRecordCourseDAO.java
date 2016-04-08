package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.AccessRecordCourse;

public class AccessRecordCourseDAO extends CHandleJPAEntity<AccessRecordCourse>
{
	public AccessRecordCourseDAO(EntityManager entityManager)
	{
		super(entityManager);
	}
}
