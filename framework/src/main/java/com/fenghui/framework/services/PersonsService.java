package com.fenghui.framework.services;

import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpaentities.Person;

public interface PersonsService
{
	@Transactional
	public boolean addPersons(Person persons);
	
	@Transactional
	public boolean removePersons(Person persons);
	
	@Transactional
	public boolean modifyPersons(Person persons);
	
	public Person findPersons(Person persons);
	
	public List<Person> listPersons();

}
