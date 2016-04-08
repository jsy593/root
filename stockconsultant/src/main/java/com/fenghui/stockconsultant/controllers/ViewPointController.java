package com.fenghui.stockconsultant.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.fenghui.bases.handlejpa.ControllerBase;
import com.fenghui.bases.jpadtos.ViewpointDTO;
import com.fenghui.bases.jpaentities.Teacher;
import com.fenghui.beans.webapp.ViewPointBean;


@ManagedBean(name = "viewPointsController")
@SessionScoped
public class ViewPointController extends ControllerBase implements Serializable
{
	private static final long serialVersionUID = 7922384537879977380L;
	
	ViewPointBean viewPointBean=new ViewPointBean();
	Teacher teacher=new Teacher();
	private List<ViewpointDTO> viewPonitlist=viewPointBean.listViewPoint(teacher);
	public String listViewPonit()
	{
		setViewPonitlist(viewPointBean.listViewPoint(teacher));
		return "/users/listInformations.xhtml";
	}

	public List<ViewpointDTO> getViewPonitlist()
	{
		return viewPonitlist;
	}

	public void setViewPonitlist(List<ViewpointDTO> viewPonitlist)
	{
		this.viewPonitlist = viewPonitlist;
	}
	
}
