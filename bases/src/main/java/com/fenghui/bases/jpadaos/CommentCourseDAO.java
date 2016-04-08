package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.CommentCourse;

public class CommentCourseDAO extends CHandleJPAEntity<CommentCourse>
{
	public CommentCourseDAO(EntityManager entityManager)
	{
		super(entityManager);
	}
}