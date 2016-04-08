package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpadtos.ViewpointDTO;

public class ViewPointDAO extends CHandleJPAEntity<ViewpointDTO>
{

	public ViewPointDAO(EntityManager entityManager)
	{
		super(entityManager);
	}

}
