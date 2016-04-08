package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.List;

import com.fenghui.bases.jpaentities.Person;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.PersonsService;
import com.fenghui.services.managers.PersonsManager;

public class PersonsBean extends BeanBase implements Serializable
{
	private static final long serialVersionUID = 5536447569020152612L;

	public boolean addPersons(Person persons)
	{
		PersonsService personsService = getProxyPersonsService();
		return personsService.addPersons(persons);
	}

	public boolean removePerson(Person persons)
	{
		PersonsService personsService = getProxyPersonsService();
		return personsService.removePersons(persons);
	}

	public boolean modifyPerson(Person persons)
	{
		PersonsService personsService = getProxyPersonsService();
		return personsService.modifyPersons(persons);
	}

	public Person findPersons(Person persons)
	{
		PersonsService personsService = getProxyPersonsService();
		return personsService.findPersons(persons);

	}

	public List<Person> listPersons()
	{
		PersonsService personsService = getProxyPersonsService();
		return personsService.listPersons();
	}

	private PersonsService getProxyPersonsService()
	{
		PersonsService personsManager = new PersonsManager(entityManager);
		PersonsService personsServiceProxy = (PersonsService) (jpaTransactionalProxyManager).proxyFor(personsManager);
		return personsServiceProxy;
	}
}
