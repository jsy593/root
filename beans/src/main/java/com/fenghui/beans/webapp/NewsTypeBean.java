package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.List;

import com.fenghui.bases.jpaentities.NewsType;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.NewsTypeService;
import com.fenghui.services.managers.NewsTypeManager;

public class NewsTypeBean extends BeanBase implements Serializable
{

	private static final long serialVersionUID = -1448503201694674769L;
	
	public boolean addNewsType(NewsType newsType)
	{
		NewsTypeService newsTypeService = getProxyNewsTypeService();
		return newsTypeService.addNewsType(newsType);
	}

	public boolean removeNews(NewsType newsType)
	{
		NewsTypeService newsService = getProxyNewsTypeService();
		return newsService.removeNewsType(newsType);
		
	}

	public boolean modifyNews(NewsType newsType)
	{
		NewsTypeService newsService = getProxyNewsTypeService();
		return newsService.modifyNewsType(newsType);
	}

	public NewsType findNewsType(NewsType newsType)
	{
		NewsTypeService newsService = getProxyNewsTypeService();
		return newsService.findNewsType(newsType);
	}

	public List<NewsType> listNewsType()
	{
		NewsTypeService newsService = getProxyNewsTypeService();
		return newsService.listNewsType();
	}

	private NewsTypeService getProxyNewsTypeService()
	{
		NewsTypeService newsManager = new NewsTypeManager(entityManager);
		NewsTypeService newsServiceProxy = (NewsTypeManager) (jpaTransactionalProxyManager).proxyFor(newsManager);
		return newsServiceProxy;
	}

}
