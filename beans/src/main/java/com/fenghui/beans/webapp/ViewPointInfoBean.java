package com.fenghui.beans.webapp;

import java.io.Serializable;

import com.fenghui.bases.jpadtos.ViewpointDTO;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.ViewPointService;
import com.fenghui.services.managers.ViewPointManager;

public class ViewPointInfoBean extends BeanBase implements Serializable
{
	private static final long serialVersionUID = 3503137058049883636L;
	
	public ViewpointDTO findViewPointInfo(ViewpointDTO viewPointDto)
	{
		ViewPointService viewPointService = getProxyViewPointService();
		return viewPointService.findViewPoint(viewPointDto);
	}
	private ViewPointService getProxyViewPointService()
	{
		ViewPointService viewPointManager = new ViewPointManager(entityManager);
		ViewPointService viewPointServiceProxy = (ViewPointService) (jpaTransactionalProxyManager).proxyFor(viewPointManager);
		return viewPointServiceProxy;
	}
}
