package com.fenghui.services.managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.NewsTypeDAO;
import com.fenghui.bases.jpaentities.NewsType;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.NewsTypeService;

public class NewsTypeManager implements NewsTypeService
{
	protected IHandleEntity<NewsType> handlenewstype;

	EntityManager entityManager;
	
	private final String JPQL_FIND_NEWSTYPE = "select e from NEWSTYPE e where e.ID=:newsId";
	private final String JPQL_LIST_NEWSTYPE = "select e leavewordsfrom NEWSTYPE e";

	public NewsTypeManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public boolean addNewsType(NewsType newsType)
	{
		handlenewstype = new NewsTypeDAO(entityManager);
		handlenewstype.addEntity(newsType);
		handlenewstype.close();
		return true;
	}

	@Override
	@Transactional
	public boolean removeNewsType(NewsType newsType)
	{
		handlenewstype = new NewsTypeDAO(entityManager);
		handlenewstype.deleteEntity(newsType);
		handlenewstype.close();
		return true;
	}

	@Override
	@Transactional
	public boolean modifyNewsType(NewsType newsType)
	{
		handlenewstype = new NewsTypeDAO(entityManager);
		handlenewstype.modifyEntity(newsType);
		handlenewstype.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public NewsType findNewsType(NewsType newsType)
	{
		Query query = entityManager.createQuery(JPQL_FIND_NEWSTYPE);
//	query.setParameter(position, value)
		List<NewsType> listNewsType = query.getResultList();
		
		return listNewsType.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NewsType> listNewsType()
	{
		Query query = entityManager.createQuery(JPQL_LIST_NEWSTYPE);
		List<NewsType> listNewsType = query.getResultList();

		return listNewsType;
	}

}
