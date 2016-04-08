package com.fenghui.stockconsultant.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.fenghui.bases.handlejpa.ControllerBase;
import com.fenghui.bases.jpaentities.TeacherOtherLink;
import com.fenghui.beans.webapp.TeacherOtherLinkBean;


@ManagedBean(name="teacherOtherLinksController")
@SessionScoped
public class TeacherOtherLinksController extends ControllerBase implements Serializable
{
	
	private static final long serialVersionUID = 8678303097735041376L;

	TeacherOtherLinkBean teacherOtherLinkBean = new TeacherOtherLinkBean();
	private TeacherOtherLink teacherOtherLink = new TeacherOtherLink();
	private TeacherOtherLink updatingteacherOtherLink = new TeacherOtherLink();
	private List<TeacherOtherLink> listTeacherOtherLink = teacherOtherLinkBean.listTeacherOtherLinks();

	public String addTeacherOtherLinks(TeacherOtherLink teacherOtherLink){
		teacherOtherLinkBean.addTeacherOtherLink(teacherOtherLink);
		teacherOtherLink = new TeacherOtherLink();
		listTeacherOtherLink = teacherOtherLinkBean.listTeacherOtherLinks();
		return "/users/ajaxAddUser.xhtml";
	}
								
	public String removeTeacherOtherLinks(TeacherOtherLink teacherOtherLinks){
		return "";
	}
	
	public String modifyTeachersTeacherOtherLinks(TeacherOtherLink teacherOtherLinks){
		return "";
	}
	
	public String findTeacherOtherLinks(TeacherOtherLink teacherOtherLinks){
		teacherOtherLinkBean.findTeacherOtherLinks(teacherOtherLinks);
		return "teacherMessage.xhtml";
	}
	
	public String listTeacherOtherLinks(){
		return "";
	}

	public TeacherOtherLinkBean getTeacherOtherLinkBean()
	{
		return teacherOtherLinkBean;
	}

	public void setTeacherOtherLinkBean(TeacherOtherLinkBean teacherOtherLinkBean)
	{
		this.teacherOtherLinkBean = teacherOtherLinkBean;
	}

	public TeacherOtherLink getTeacherOtherLink()
	{
		return teacherOtherLink;
	}

	public void setTeacherOtherLink(TeacherOtherLink teacherOtherLink)
	{
		this.teacherOtherLink = teacherOtherLink;
	}

	public TeacherOtherLink getUpdatingteacherOtherLink()
	{
		return updatingteacherOtherLink;
	}

	public void setUpdatingteacherOtherLink(TeacherOtherLink updatingteacherOtherLink)
	{
		this.updatingteacherOtherLink = updatingteacherOtherLink;
	}

	public List<TeacherOtherLink> getListTeacherOtherLink()
	{
		return listTeacherOtherLink;
	}

	public void setListTeacherOtherLink(List<TeacherOtherLink> listTeacherOtherLink)
	{
		this.listTeacherOtherLink = listTeacherOtherLink;
	}

	
	
}
