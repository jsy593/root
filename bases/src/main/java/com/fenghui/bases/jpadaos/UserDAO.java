package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.User;

public class UserDAO extends CHandleJPAEntity<User>
{
	public UserDAO(EntityManager entityManager){
		super(entityManager);
	}

}
