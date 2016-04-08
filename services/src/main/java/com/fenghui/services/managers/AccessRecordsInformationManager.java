package com.fenghui.services.managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.AccessRecordInformationDAO;
import com.fenghui.bases.jpaentities.AccessRecordInformation;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.AccessRecordsInformationService;

public class AccessRecordsInformationManager implements AccessRecordsInformationService
{
	protected IHandleEntity<AccessRecordInformation> handleAccessRecordsInformation;

	EntityManager entityManager;

	private final String JPQL_FIND_ACCESSRECORDSINFORMATION = "select e from AccessRecordsInformation e where e.id=:id";
	private final String JPQL_FIND_ACCESSRECORDSINFORMATIONS = "select e from AccessRecordsInformation e";

	public AccessRecordsInformationManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public boolean addAccessRecordsInformation(AccessRecordInformation accessRecordsInformation)
	{
		handleAccessRecordsInformation = new AccessRecordInformationDAO(entityManager);
		handleAccessRecordsInformation.addEntity(accessRecordsInformation);
		handleAccessRecordsInformation.close();
		return true;
	}

	@Override
	@Transactional
	public boolean modifyAccessRecordsInformation(AccessRecordInformation accessRecordsInformation)
	{
		handleAccessRecordsInformation = new AccessRecordInformationDAO(entityManager);
		handleAccessRecordsInformation.modifyEntity(accessRecordsInformation);
		handleAccessRecordsInformation.close();
		return false;
	}

	@Override
	@Transactional
	public boolean removeAccessRecordsInformation(AccessRecordInformation accessRecordsInformation)
	{
		handleAccessRecordsInformation = new AccessRecordInformationDAO(entityManager);
		handleAccessRecordsInformation.deleteEntity(accessRecordsInformation);
		handleAccessRecordsInformation.close();
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public AccessRecordInformation findAccessRecordsInformation(AccessRecordInformation accessRecordsInformation)
	{
		Query query = entityManager.createQuery(JPQL_FIND_ACCESSRECORDSINFORMATION);
		query.setParameter("id", accessRecordsInformation.getId());
		List<AccessRecordInformation> accessRecordsInformations = query.getResultList();

		if (accessRecordsInformations.size() == 0)
		{
			return null;
		}
		else
		{
			return (AccessRecordInformation) accessRecordsInformations.get(0);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AccessRecordInformation> listAccessRecordsInformation()
	{
		Query query = entityManager.createQuery(JPQL_FIND_ACCESSRECORDSINFORMATIONS);
		List<AccessRecordInformation> accessRecordsInformations = query.getResultList();

		return accessRecordsInformations;
	}
}
