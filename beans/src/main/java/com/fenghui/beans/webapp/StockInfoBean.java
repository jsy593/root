package com.fenghui.beans.webapp;

import java.io.Serializable;

import com.fenghui.bases.jpadtos.InformationDTO;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.InformationService;
import com.fenghui.services.managers.InformationManager;

public class StockInfoBean extends BeanBase implements Serializable
{
	private static final long serialVersionUID = -6155792036528746489L;

	public InformationDTO findInformationDTO(InformationDTO informationDTO)
	{
		InformationService informationService = getProxyInformationsService();
		return informationService.findInformationDTO(informationDTO);
	}

	private InformationService getProxyInformationsService()
	{
		InformationService informationsManager = new InformationManager(entityManager);
		InformationService informationsServiceProxy = (InformationService) (jpaTransactionalProxyManager)
				.proxyFor(informationsManager);

		return informationsServiceProxy;
	}
}
