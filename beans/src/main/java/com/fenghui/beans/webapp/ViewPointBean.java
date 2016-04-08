package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.List;

import com.fenghui.bases.jpadtos.ViewpointDTO;
import com.fenghui.bases.jpaentities.Teacher;
import com.fenghui.bases.jpaentities.ViewPoint;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.ViewPointService;
import com.fenghui.services.managers.ViewPointManager;

public class ViewPointBean extends BeanBase implements Serializable
{
	private static final long serialVersionUID = -7536991364111472617L;
	
	public boolean addViewPoint(ViewpointDTO viewPointDto)
	{
		ViewPointService viewPointService = getProxyViewPointService();
		viewPointService.addViewPoint(viewPointDto);
		return true;
	}
	
	public boolean cancelUser(ViewpointDTO viewPointDto)
	{
		ViewPointService viewPointService = getProxyViewPointService();
		viewPointDto =findViewPoint(viewPointDto);
		return viewPointService.cancelViewPoint(viewPointDto);
	}
	
	public boolean modifyUser(ViewpointDTO viewPointDto)
	{
		ViewPointService viewPointService = getProxyViewPointService();
		return viewPointService.modifyViewPoint(viewPointDto);
	}
	
	public ViewpointDTO findViewPoint(ViewpointDTO viewPointDto)
	{
		ViewPointService viewPointService = getProxyViewPointService();
		return viewPointService.findViewPoint(viewPointDto);
	}

	public List<ViewpointDTO> listViewPoint(Teacher teacher)
	{
		ViewPointService viewPointService = getProxyViewPointService();
		return viewPointService.listViewPoint(teacher);
	}
	
	
	
	
	private ViewPointService getProxyViewPointService()
	{
		ViewPointService viewPointManager = new ViewPointManager(entityManager);
		ViewPointService viewPointServiceProxy = (ViewPointService) (jpaTransactionalProxyManager).proxyFor(viewPointManager);
		return viewPointServiceProxy;
	}

}
