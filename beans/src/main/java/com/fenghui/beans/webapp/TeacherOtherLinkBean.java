package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.List;

import com.fenghui.bases.jpaentities.TeacherOtherLink;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.TeacherOtherLinkService;
import com.fenghui.services.managers.TeacherOtherLinksManager;

public class TeacherOtherLinkBean extends BeanBase implements Serializable
{

	private static final long serialVersionUID = 4784710243148291538L;
	public boolean addTeacherOtherLink(TeacherOtherLink teacherOtherLink){
		TeacherOtherLinkService teacherOtherLinkService = getProxyTeacherOtherLinkService();
		return teacherOtherLinkService.addTeacherOtherLink(teacherOtherLink);
	}
								
	public boolean removeTeacherOtherLinks(TeacherOtherLink teacherOtherLink){
		TeacherOtherLinkService teacherOtherLinkService = getProxyTeacherOtherLinkService();
		return teacherOtherLinkService.removeTeacherOtherLink(teacherOtherLink);
	}
	
	public boolean modifyTeachersTeacherOtherLinks(TeacherOtherLink teacherOtherLink){
		TeacherOtherLinkService teacherOtherLinkService = getProxyTeacherOtherLinkService();
		return teacherOtherLinkService.modifyTeacherOtherLink(teacherOtherLink);
	}
	
	public TeacherOtherLink findTeacherOtherLinks(TeacherOtherLink teacherOtherLink){
		TeacherOtherLinkService teacherOtherLinkService = getProxyTeacherOtherLinkService();
		return teacherOtherLinkService.findTeacherOtherLink(teacherOtherLink);
	}
	
	public List<TeacherOtherLink> listTeacherOtherLinks(){
		TeacherOtherLinkService teacherOtherLinkService = getProxyTeacherOtherLinkService();
		return teacherOtherLinkService.listTeacherOtherLink();
	}
	
	private TeacherOtherLinkService getProxyTeacherOtherLinkService()
	{
		TeacherOtherLinkService teacherOtherLinkManager = new TeacherOtherLinksManager(entityManager);
		TeacherOtherLinkService teacherOtherLinkServiceProxy = (TeacherOtherLinkService) (jpaTransactionalProxyManager).proxyFor(teacherOtherLinkManager);

		return teacherOtherLinkServiceProxy;
	}
}
