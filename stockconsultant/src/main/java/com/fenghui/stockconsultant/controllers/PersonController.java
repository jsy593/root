package com.fenghui.stockconsultant.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.fenghui.bases.handlejpa.ControllerBase;
import com.fenghui.bases.jpaentities.Person;
import com.fenghui.beans.webapp.PersonsBean;

@ManagedBean(name = "personsController")
@SessionScoped
public class PersonController  extends ControllerBase implements Serializable
{

	private static final long serialVersionUID = -3783215544237967530L;
	
	PersonsBean personsBean = new PersonsBean();
	private Person persons = new Person();
	private Person updatingPersons = new Person();
	private List<Person> listPersons = personsBean.listPersons();

	public String login(String usernName,String passWord,String prodectType){
//		personsBean
		return null;
		
	}
}
