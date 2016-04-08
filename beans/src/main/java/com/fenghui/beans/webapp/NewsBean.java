package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.List;

import com.fenghui.bases.jpaentities.News;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.NewsService;
import com.fenghui.services.managers.NewsManager;

public class NewsBean extends BeanBase implements Serializable
{

	private static final long serialVersionUID = -5504504802935565894L;

	public boolean addNews(News news)
	{
		NewsService newsService = getProxyNewsService();
		return newsService.addNews(news);
	}

	public boolean removeNews(News news)
	{
		NewsService newsService = getProxyNewsService();
		return newsService.removeNews(news);
		
	}

	public boolean modifyNews(News news)
	{
		NewsService newsService = getProxyNewsService();
		return newsService.modifyNews(news);
	}

	public News findNews(News news)
	{
		NewsService newsService = getProxyNewsService();
		return newsService.findNews(news);
	}

	public List<News> listNews()
	{
		NewsService newsService = getProxyNewsService();
		return newsService.listNews();
	}

	private NewsService getProxyNewsService()
	{
		NewsService newsManager = new NewsManager(entityManager);
		NewsService newsServiceProxy = (NewsService) (jpaTransactionalProxyManager).proxyFor(newsManager);
		return newsServiceProxy;
	}
}
