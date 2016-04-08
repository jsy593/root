package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.TeacherProduct;

public class TeacherProductDAO extends CHandleJPAEntity<TeacherProduct>
{

	public TeacherProductDAO(EntityManager entityManager)
	{
		super(entityManager);
	}

}
