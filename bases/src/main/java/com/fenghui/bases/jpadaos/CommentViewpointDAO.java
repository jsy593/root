package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.CommentViewpoint;

public class CommentViewpointDAO extends CHandleJPAEntity<CommentViewpoint>
{
	public CommentViewpointDAO(EntityManager entityManager)
	{
		super(entityManager);
	}
}
