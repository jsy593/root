package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.List;

import com.fenghui.bases.jpaentities.AccessRecordCourse;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.AccessRecordsCourseService;
import com.fenghui.services.managers.AccessRecordsCourseManager;

public class AccessRecordsCourseBean extends BeanBase implements Serializable
{
	private static final long serialVersionUID = 4119283637200639881L;

	public boolean addAccessRecordsCourse(AccessRecordCourse accessRecordsCourse)
	{
		AccessRecordsCourseService accessRecordsCourseService = getProxyAccessRecordsCourseService();

		accessRecordsCourseService.addAccessRecordsCourse(accessRecordsCourse);
		return true;
	}

	public boolean modifyAccessRecordsCourse(AccessRecordCourse accessRecordsCourse)
	{
		AccessRecordsCourseService accessRecordsCourseService = getProxyAccessRecordsCourseService();
		return accessRecordsCourseService.modifyAccessRecordsCourse(accessRecordsCourse);
	}

	public boolean removeAccessRecordsCourse(AccessRecordCourse accessRecordsCourse)
	{
		AccessRecordsCourseService accessRecordsCourseService = getProxyAccessRecordsCourseService();
		return accessRecordsCourseService.removeAccessRecordsCourse(accessRecordsCourse);
	}

	public AccessRecordCourse findAccessRecordsCourse(AccessRecordCourse accessRecordsCourse)
	{
		AccessRecordsCourseService accessRecordsCourseService = getProxyAccessRecordsCourseService();
		return accessRecordsCourseService.findAccessRecordsCourse(accessRecordsCourse);
	}

	public List<AccessRecordCourse> listAccessRecordsCourses()
	{
		AccessRecordsCourseService accessRecordsCourseService = getProxyAccessRecordsCourseService();
		return accessRecordsCourseService.listAccessRecordsCourse();
	}

	private AccessRecordsCourseService getProxyAccessRecordsCourseService()
	{
		AccessRecordsCourseService accessRecordsCourseManager = new AccessRecordsCourseManager(entityManager);
		AccessRecordsCourseService accessRecordsCourseServiceProxy = (AccessRecordsCourseService) (jpaTransactionalProxyManager)
				.proxyFor(accessRecordsCourseManager);

		return accessRecordsCourseServiceProxy;
	}
}
