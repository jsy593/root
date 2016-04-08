package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.List;
import com.fenghui.bases.jpaentities.AccessRecordViewpoint;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.AccessRecordViewpointService;
import com.fenghui.services.managers.AccessRecordViewpointManager;


public class AccessRecordViewpointBean extends BeanBase implements Serializable
{
	private static final long serialVersionUID = 3981865758469631049L;
	
	public boolean addAccessRecordViewpoint(AccessRecordViewpoint accessRecordViewpoint)
	{
		AccessRecordViewpointService accessRecordViewpointService = getProxyAccessRecordViewpointService();
		accessRecordViewpointService.addAccessRecordViewpoint(accessRecordViewpoint);
		return true;
	}
	
	public boolean cancelAccessRecordViewpoint(AccessRecordViewpoint accessRecordViewpoint)
	{
		AccessRecordViewpointService accessRecordViewpointService = getProxyAccessRecordViewpointService();
		accessRecordViewpoint =findAccessRecordViewpoint(accessRecordViewpoint);
		return accessRecordViewpointService.cancelAccessRecordViewpoint(accessRecordViewpoint);
	}
	
	
	public AccessRecordViewpoint findAccessRecordViewpoint(AccessRecordViewpoint accessRecordViewpoint)
	{
		AccessRecordViewpointService accessRecordViewpointService = getProxyAccessRecordViewpointService();
		return accessRecordViewpointService.findAccessRecordViewpoint(accessRecordViewpoint);
	}

	public List<AccessRecordViewpoint> listAccessRecordViewpoint()
	{
		AccessRecordViewpointService accessRecordViewpointService = getProxyAccessRecordViewpointService();
		return accessRecordViewpointService.listAccessRecordViewpoint();
	}
	
	
	

	private AccessRecordViewpointService getProxyAccessRecordViewpointService()
	{
		AccessRecordViewpointService accessRecordViewpointManager = new AccessRecordViewpointManager(entityManager);
		AccessRecordViewpointService accessRecordViewpointServiceProxy = (AccessRecordViewpointService) (jpaTransactionalProxyManager).proxyFor(accessRecordViewpointManager);
		return accessRecordViewpointServiceProxy;
	}
	
}
