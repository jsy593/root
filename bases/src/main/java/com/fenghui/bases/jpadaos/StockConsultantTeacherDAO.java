package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.StockConsultantTeacher;

public class StockConsultantTeacherDAO extends CHandleJPAEntity<StockConsultantTeacher>
{
	public StockConsultantTeacherDAO(EntityManager entityManager)
	{
		super(entityManager);
	}
}
