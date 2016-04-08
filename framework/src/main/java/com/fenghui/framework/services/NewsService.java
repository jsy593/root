package com.fenghui.framework.services;

import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpaentities.News;

public interface NewsService
{
	@Transactional
	public boolean addNews(News news);
	
	@Transactional
	public boolean removeNews(News news);
	
	@Transactional
	public boolean modifyNews(News news);
	
	public News findNews(News news);
	
	public List<News> listNews();
}
