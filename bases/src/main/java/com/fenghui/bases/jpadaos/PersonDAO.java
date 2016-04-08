package com.fenghui.bases.jpadaos;

import javax.persistence.EntityManager;

import com.fenghui.bases.handlejpa.CHandleJPAEntity;
import com.fenghui.bases.jpaentities.Person;

public class PersonDAO extends CHandleJPAEntity<Person>
{

	public PersonDAO(EntityManager entityManager)
	{
		super(entityManager);
	}

}
