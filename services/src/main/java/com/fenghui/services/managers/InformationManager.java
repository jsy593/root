package com.fenghui.services.managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.InformationDAO;
import com.fenghui.bases.jpadtos.InformationDTO;
import com.fenghui.bases.jpaentities.Information;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.InformationService;

public class InformationManager implements InformationService
{
	protected IHandleEntity<Information> handleInformation;

	EntityManager entityManager;

	private final String JPQL_FIND_INFORMATION = "select e from Information e where e.id=:id";
	private final String JPQL_FIND_INFORMATIONDTO = "select e from InformationDTO e where e.id=:id";
	private final String JPQL_FIND_INFORMATIONS = "select e from InformationDTO e where e.teachersDTO.id=:teacherId";

	public InformationManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public boolean addInformation(Information information)
	{
		handleInformation = new InformationDAO(entityManager);
		handleInformation.addEntity(information);
		handleInformation.close();
		return true;
	}

	@Override
	@Transactional
	public boolean modifyInformation(Information information)
	{
		handleInformation = new InformationDAO(entityManager);
		handleInformation.modifyEntity(information);
		handleInformation.close();
		return false;
	}

	@Override
	@Transactional
	public boolean removeInformation(Information information)
	{
		handleInformation = new InformationDAO(entityManager);
		handleInformation.deleteEntity(information);
		handleInformation.close();
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Information findInformation(Information information)
	{
		Query query = entityManager.createQuery(JPQL_FIND_INFORMATION);
		query.setParameter("id", information.getId());
		List<Information> informations = query.getResultList();

		if (informations.size() == 0)
		{
			return null;
		}
		else
		{
			return (Information) informations.get(0);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<InformationDTO> listInformation(int teacherId)
	{
		Query query = entityManager.createQuery(JPQL_FIND_INFORMATIONS);
		query.setParameter("teacherId", teacherId);
		List<InformationDTO> informations = query.getResultList();
		return informations;
	}

	@Override
	@SuppressWarnings("unchecked")
	public InformationDTO findInformationDTO(InformationDTO informationdto)
	{
		Query query = entityManager.createQuery(JPQL_FIND_INFORMATIONDTO);
		query.setParameter("id", informationdto.getId());
		List<InformationDTO> informationdtos = query.getResultList();

		if (informationdtos.size() == 0)
		{
			return null;
		}
		else
		{
			return (InformationDTO) informationdtos.get(0);
		}
	}

}
