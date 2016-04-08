package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.Course;

public class CourseDAO extends CHandleJPAEntity<Course>
{
	public CourseDAO(EntityManager entityManager)
	{
		super(entityManager);
	}
}
