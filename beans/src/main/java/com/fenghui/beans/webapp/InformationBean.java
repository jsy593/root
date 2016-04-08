package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.List;

import com.fenghui.bases.jpadtos.InformationDTO;
import com.fenghui.bases.jpaentities.Information;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.InformationService;
import com.fenghui.services.managers.InformationManager;

public class InformationBean extends BeanBase implements Serializable
{

	private static final long serialVersionUID = 3573431477494932390L;

	public boolean addInformation(Information information)
	{
		InformationService informationService = getProxyInformationsService();
		informationService.addInformation(information);
		return true;
	}

	public boolean modifyInformation(Information information)
	{
		InformationService informationService = getProxyInformationsService();
		return informationService.modifyInformation(information);
	}

	public boolean removeInformation(Information information)
	{
		InformationService informationService = getProxyInformationsService();
		return informationService.removeInformation(information);
	}

	public Information findInformation(Information information)
	{
		InformationService informationService = getProxyInformationsService();
		return informationService.findInformation(information);
	}

	public List<InformationDTO> listInformation(int teacherId)
	{
		InformationService informationService = getProxyInformationsService();
		return informationService.listInformation(teacherId);
	}

	private InformationService getProxyInformationsService()
	{
		InformationService informationsManager = new InformationManager(entityManager);
		InformationService informationsServiceProxy = (InformationService) (jpaTransactionalProxyManager)
				.proxyFor(informationsManager);

		return informationsServiceProxy;
	}
}
