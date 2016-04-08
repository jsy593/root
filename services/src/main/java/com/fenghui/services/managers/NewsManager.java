package com.fenghui.services.managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.NewsDAO;
import com.fenghui.bases.jpaentities.News;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.NewsService;

public class NewsManager implements NewsService
{
	protected IHandleEntity<News> handleUser;

	EntityManager entityManager;
	
	private final String JPQL_FIND_NEWS = "select e from News e where e.id=:newsId";
	private final String JPQL_LIST_NEWS = "select e from News e order by e.releaseTime desc";

	public NewsManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	} 

	@Override
	@Transactional
	public boolean addNews(News news)
	{
		handleUser = new NewsDAO(entityManager);
		handleUser.addEntity(news);
		handleUser.close();
		return true;
	}

	@Override
	@Transactional
	public boolean removeNews(News news)
	{
		handleUser = new NewsDAO(entityManager);
		handleUser.deleteEntity(news);
		handleUser.close();
		return true;
	}

	@Override
	@Transactional
	public boolean modifyNews(News news)
	{
		handleUser = new NewsDAO(entityManager);
		handleUser.modifyEntity(news);
		handleUser.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public News findNews(News news)
	{
		Query query = entityManager.createQuery(JPQL_FIND_NEWS);
		query.setParameter("newsId", news.getId());
		List<News> listNew = query.getResultList();
		if (listNew.size() == 0){
			return null;
		}else{
			return (News)listNew.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> listNews()
	{
		Query query = entityManager.createQuery(JPQL_LIST_NEWS);
		query.setFirstResult(0);
		query.setMaxResults(5);
		List<News> listNews = query.getResultList();
		return listNews;
	}

}
