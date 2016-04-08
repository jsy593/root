package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.List;
import com.fenghui.bases.jpaentities.PublishedChatRecord;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.PublishedChatRecordsService;
import com.fenghui.services.managers.PublishedChatRecordManager;
public class PublishedChatRecordsBean extends BeanBase implements Serializable
{
	private static final long serialVersionUID = -3468227146667405273L;
	
	public boolean addPublishedChatRecords(PublishedChatRecord publishedChatRecords)
	{
		PublishedChatRecordsService publishedChatRecordsService = getProxyPublishedChatRecordsService();
		publishedChatRecordsService.addPublishedChatRecords(publishedChatRecords);
		return true;
	}
	
	public boolean cancelPublishedChatRecords(PublishedChatRecord publishedChatRecords)
	{
		PublishedChatRecordsService publishedChatRecordsService = getProxyPublishedChatRecordsService();
		publishedChatRecords =findPublishedChatRecords(publishedChatRecords);
		return publishedChatRecordsService.cancelPublishedChatRecords(publishedChatRecords);
	}
	
	public PublishedChatRecord findPublishedChatRecords(PublishedChatRecord publishedChatRecords)
	{
		PublishedChatRecordsService publishedChatRecordsService = getProxyPublishedChatRecordsService();
		return publishedChatRecordsService.findPublishedChatRecords(publishedChatRecords);
	}

	public List<PublishedChatRecord> listPublishedChatRecords()
	{
		PublishedChatRecordsService publishedChatRecordsService = getProxyPublishedChatRecordsService();
		return publishedChatRecordsService.listPublishedChatRecords();
	}
	
	private PublishedChatRecordsService getProxyPublishedChatRecordsService()
	{
		PublishedChatRecordsService PublishedChatRecordsManager = new PublishedChatRecordManager(entityManager);
		PublishedChatRecordsService publishedChatRecordsServiceProxy = (PublishedChatRecordsService) (jpaTransactionalProxyManager).proxyFor(PublishedChatRecordsManager);
		return publishedChatRecordsServiceProxy;
	}

}
