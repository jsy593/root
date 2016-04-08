package com.fenghui.services.managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.TeacherOtherLinkDAO;
import com.fenghui.bases.jpaentities.TeacherOtherLink;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.TeacherOtherLinkService;

public class TeacherOtherLinksManager implements TeacherOtherLinkService
{
	protected IHandleEntity<TeacherOtherLink> handleTeacherOtherLink;

	EntityManager entityManager;
	
	private final String JPQL_FIND_TEACHEROTHERLINK = "select e from TEACHER_OTHER_LINKS e where e.TEACHER=:teacher";
	private final String JPQL_LIST_TEACHEROTHERLINK = "select e from TEACHER_OTHER_LINKS e";

	public TeacherOtherLinksManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}


	@Override
	@Transactional
	public boolean addTeacherOtherLink(TeacherOtherLink teacherOtherLinks)
	{
		handleTeacherOtherLink = new TeacherOtherLinkDAO(entityManager);
		handleTeacherOtherLink.addEntity(teacherOtherLinks);
		handleTeacherOtherLink.close();
		return true;
	}

	@Override
	public boolean removeTeacherOtherLink(TeacherOtherLink teacherOtherLinks)
	{
		handleTeacherOtherLink = new TeacherOtherLinkDAO(entityManager);
		handleTeacherOtherLink.deleteEntity(teacherOtherLinks);
		handleTeacherOtherLink.close();
		return true;
	}

	@Override
	public boolean modifyTeacherOtherLink(TeacherOtherLink teacherOtherLink)
	{
		handleTeacherOtherLink = new TeacherOtherLinkDAO(entityManager);
		handleTeacherOtherLink.modifyEntity(teacherOtherLink);
		handleTeacherOtherLink.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TeacherOtherLink findTeacherOtherLink(TeacherOtherLink teacherOtherLink)
	{
		Query query = entityManager.createQuery(JPQL_FIND_TEACHEROTHERLINK);
		query.setParameter("teacher", teacherOtherLink.getTeacher());
		List<TeacherOtherLink> listteacherOtherLink = query.getResultList();
		return listteacherOtherLink.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TeacherOtherLink> listTeacherOtherLink()
	{
		Query query = entityManager.createQuery(JPQL_LIST_TEACHEROTHERLINK);
		List<TeacherOtherLink> listTeacherOtherLink = query.getResultList();
		return listTeacherOtherLink;
	}

}
