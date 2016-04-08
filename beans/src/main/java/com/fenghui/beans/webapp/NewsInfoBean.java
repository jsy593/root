package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.List;

import com.fenghui.bases.jpaentities.News;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.NewsService;
import com.fenghui.services.managers.NewsManager;

public class NewsInfoBean extends BeanBase implements Serializable
{

	private static final long serialVersionUID = 1128051515329634706L;

	public News findNews(News news)
	{
		NewsService newsService = getProxyNewsService();
		return newsService.findNews(news);
	}

	private NewsService getProxyNewsService()
	{
		NewsService newsManager = new NewsManager(entityManager);
		NewsService newsServiceProxy = (NewsService) (jpaTransactionalProxyManager).proxyFor(newsManager);
		return newsServiceProxy;
	}
}
