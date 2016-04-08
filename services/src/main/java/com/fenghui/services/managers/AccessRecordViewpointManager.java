package com.fenghui.services.managers;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.AccessRecordViewpointDAO;
import com.fenghui.bases.jpaentities.AccessRecordViewpoint;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.AccessRecordViewpointService;

public class AccessRecordViewpointManager implements AccessRecordViewpointService
{

	protected IHandleEntity<AccessRecordViewpoint> handleAccessRecordViewpoint;

	EntityManager entityManager;
	
	private final String JPQL_FIND_ACCESSRECORDVIEWPOINT = "select e from AccessRecordViewpoint e where e.id=:id";
	private final String JPQL_LIST_ACCESSRECORDVIEWPOINT = "select e from AccessRecordViewpoint e";

	public AccessRecordViewpointManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	
	@Override
	@Transactional
	public boolean addAccessRecordViewpoint(AccessRecordViewpoint accessRecordViewpoint)
	{
		handleAccessRecordViewpoint = new AccessRecordViewpointDAO(entityManager);
		accessRecordViewpoint.setAccessingTime(new Date());
		handleAccessRecordViewpoint.addEntity(accessRecordViewpoint);
		handleAccessRecordViewpoint.close();
		return true;
	}

	@Override
	@Transactional
	public boolean cancelAccessRecordViewpoint(AccessRecordViewpoint accessRecordViewpoint)
	{
		handleAccessRecordViewpoint = new AccessRecordViewpointDAO(entityManager);
		handleAccessRecordViewpoint.deleteEntity(accessRecordViewpoint);
		handleAccessRecordViewpoint.close();
		return true;
	}
	@SuppressWarnings("unchecked")
	@Override
	public AccessRecordViewpoint findAccessRecordViewpoint(AccessRecordViewpoint accessRecordViewpoint)
	{
		Query query = entityManager.createQuery(JPQL_FIND_ACCESSRECORDVIEWPOINT);
		query.setParameter("id", accessRecordViewpoint.getId());
		List<AccessRecordViewpoint> accessRecordsViewpoints = query.getResultList();
		if (accessRecordsViewpoints.size() == 0)
		{
			return null;
		}
		else
		{
			return (AccessRecordViewpoint) accessRecordsViewpoints.get(0);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<AccessRecordViewpoint> listAccessRecordViewpoint()
	{
		Query query = entityManager.createQuery(JPQL_LIST_ACCESSRECORDVIEWPOINT);
		List<AccessRecordViewpoint> accessRecordsViewpoints = query.getResultList();

		return accessRecordsViewpoints;
	}

}
