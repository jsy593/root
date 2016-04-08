package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.List;

import com.fenghui.bases.jpaentities.AccessRecordInformation;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.AccessRecordsInformationService;
import com.fenghui.services.managers.AccessRecordsInformationManager;

public class AccessRecordsInformationBean extends BeanBase implements Serializable
{

	private static final long serialVersionUID = 4078648551324361678L;

	public boolean addAccessRecordsInformation(AccessRecordInformation accessRecordsInformation)
	{
		AccessRecordsInformationService accessRecordsInformationService = getProxyAccessRecordsInformationService();
		accessRecordsInformationService.addAccessRecordsInformation(accessRecordsInformation);
		return true;
	}

	public boolean modifyAccessRecordsInformation(AccessRecordInformation accessRecordsInformation)
	{
		AccessRecordsInformationService accessRecordsInformationService = getProxyAccessRecordsInformationService();
		return accessRecordsInformationService.modifyAccessRecordsInformation(accessRecordsInformation);
	}

	public boolean removeAccessRecordsInformation(AccessRecordInformation accessRecordsInformation)
	{
		AccessRecordsInformationService accessRecordsInformationService = getProxyAccessRecordsInformationService();
		return accessRecordsInformationService.removeAccessRecordsInformation(accessRecordsInformation);
	}

	public AccessRecordInformation findAccessRecordsInformation(AccessRecordInformation accessRecordsInformation)
	{
		AccessRecordsInformationService accessRecordsInformationService = getProxyAccessRecordsInformationService();
		return accessRecordsInformationService.findAccessRecordsInformation(accessRecordsInformation);
	}

	public List<AccessRecordInformation> listAccessRecordsInformations()
	{
		AccessRecordsInformationService accessRecordsInformationService = getProxyAccessRecordsInformationService();
		return accessRecordsInformationService.listAccessRecordsInformation();
	}

	private AccessRecordsInformationService getProxyAccessRecordsInformationService()
	{
		AccessRecordsInformationService accessRecordsInformationManager = new AccessRecordsInformationManager(
				entityManager);
		AccessRecordsInformationService accessRecordsInformationServiceProxy = (AccessRecordsInformationService) (jpaTransactionalProxyManager)
				.proxyFor(accessRecordsInformationManager);

		return accessRecordsInformationServiceProxy;
	}
}
