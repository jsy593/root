package com.fenghui.services.managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.PersonDAO;
import com.fenghui.bases.jpaentities.Person;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.PersonsService;

public class PersonsManager implements PersonsService
{
	protected IHandleEntity<Person> handlePersons;

	EntityManager entityManager;
	
	private final String JPQL_FIND_PERSONS = "select e from PERSONS e where e.userId=:userId";
	private final String JPQL_LIST_PERSONS = "select e from PERSONS e";

	public PersonsManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public boolean addPersons(Person persons)
	{
		handlePersons = new PersonDAO(entityManager);
		handlePersons.addEntity(persons);
		handlePersons.close();
		return true;
	}

	@Override
	@Transactional
	public boolean removePersons(Person persons)
	{
		handlePersons = new PersonDAO(entityManager);
		handlePersons.deleteEntity(persons);
		handlePersons.close();
		return true;
	}

	@Override
	@Transactional
	public boolean modifyPersons(Person persons)
	{
		handlePersons = new PersonDAO(entityManager);
		handlePersons.modifyEntity(persons);
		handlePersons.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Person findPersons(Person persons)
	{
		Query query = entityManager.createQuery(JPQL_FIND_PERSONS);
//		query.getParameter(name, type)
		List<Person> listPersons = query.getResultList();
		return listPersons.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listPersons()
	{
		Query query = entityManager.createQuery(JPQL_LIST_PERSONS);
		List<Person> listPersons = query.getResultList();
		return listPersons;
	}

	
}
