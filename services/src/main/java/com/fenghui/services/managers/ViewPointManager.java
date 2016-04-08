package com.fenghui.services.managers;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.ViewPointDAO;
import com.fenghui.bases.jpadtos.ViewpointDTO;
import com.fenghui.bases.jpaentities.Teacher;
import com.fenghui.bases.jpaentities.ViewPoint;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.ViewPointService;

public class ViewPointManager implements ViewPointService
{
	
	protected IHandleEntity<ViewpointDTO> handleViewPoint;

	EntityManager entityManager;
	
	private final String JPQL_FIND_VIEWPOINTS = "select e from ViewpointDTO e where e.id=:id";
	private final String JPQL_LIST_VIEWPOINTS = "select e from ViewpointDTO e where e.teacher.id=:id";

	public ViewPointManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}


	@Override
	@Transactional
	public boolean addViewPoint(ViewpointDTO viewPointDto)
	{

		handleViewPoint = new ViewPointDAO(entityManager);
		viewPointDto.setCreateTime(new Date());
		viewPointDto.setLastModifiedTime(new Date());
		handleViewPoint.addEntity(viewPointDto);
		handleViewPoint.close();
		return true;
	}

	@Override
	@Transactional
	public boolean cancelViewPoint(ViewpointDTO viewpointDto)
	{
		handleViewPoint = new ViewPointDAO(entityManager);
		handleViewPoint.deleteEntity(viewpointDto);
		handleViewPoint.close();
		return true;
	}

	@Override
	@Transactional
	public boolean modifyViewPoint(ViewpointDTO viewpointDto)
	{
		handleViewPoint = new ViewPointDAO(entityManager);
//		viewpoint.s(new Date());
		handleViewPoint.modifyEntity(viewpointDto);
		handleViewPoint.close();
		return true;
	}
	@SuppressWarnings("unchecked")
	@Override
	public ViewpointDTO findViewPoint(ViewpointDTO viewpointDto)
	{

		Query query = entityManager.createQuery(JPQL_FIND_VIEWPOINTS);
		query.setParameter("id", viewpointDto.getId());
		List<ViewpointDTO> listviewpoint = query.getResultList();
		if (listviewpoint.size() == 0)
		{
			return null;
		}
		else
		{
			return listviewpoint.get(0);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ViewpointDTO> listViewPoint(Teacher teacher)
	{
		Query query = entityManager.createQuery(JPQL_LIST_VIEWPOINTS);
		query.setParameter("id",1);
		List<ViewpointDTO> viewpoints = query.getResultList();
		return viewpoints;
	}

	
	
}
