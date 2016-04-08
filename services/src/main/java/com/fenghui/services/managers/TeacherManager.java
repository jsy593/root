package com.fenghui.services.managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.TeacherDAO;
import com.fenghui.bases.jpadtos.TeacherDTO;
import com.fenghui.bases.jpaentities.Teacher;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.TeacherService;

public class TeacherManager implements TeacherService
{
	protected IHandleEntity<Teacher> handleUser;

	EntityManager entityManager;
	
	private final String JPQL_FIND_TEACHER = "select e from TeacherDTO e where e.id=:id";
	private final String JPQL_LOGIN_TEACHER = "select e from Teacher e where e.LOGGIN_NAME=:userName and e.LOGGIN_PASSWORD=:userPassword";
	private final String JPQL_LIST_TEACHER = "select e from TeacherDTO e";

	public TeacherManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public boolean addTeacher(Teacher teacher)
	{
		handleUser = new TeacherDAO(entityManager);
		handleUser.addEntity(teacher);
		handleUser.close();
		return true;
	}

	@Override
	@Transactional
	public boolean removeTeacher(Teacher teacher)
	{
		handleUser = new TeacherDAO(entityManager);
		handleUser.deleteEntity(teacher);
		handleUser.close();
		return true;
	}

	@Override
	@Transactional
	public boolean modifyTeacher(Teacher teacher)
	{
		handleUser = new TeacherDAO(entityManager);
		handleUser.modifyEntity(teacher);
		handleUser.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Teacher findTeacher(Teacher teacher)
	{
		Query query = entityManager.createQuery(JPQL_FIND_TEACHER);
		query.setParameter("id", teacher.getId());
		List<Teacher> listTeacher = query.getResultList();

		if (listTeacher.size() == 0)
		{
			return null;
		}
		else
		{
			return  (Teacher)listTeacher.get(0);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public TeacherDTO findTeacherDTO(Teacher teacher)
	{
		Query query = entityManager.createQuery(JPQL_FIND_TEACHER);
		query.setParameter("id",teacher.getId());
		List<TeacherDTO> listTeacher = query.getResultList();

		if (listTeacher.size() == 0)
		{
			return null;
		}
		else
		{
			return  (TeacherDTO)listTeacher.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Teacher loginTeacher(Teacher teacher)
	{
		Query query = entityManager.createQuery(JPQL_LOGIN_TEACHER);
		List<Teacher> listteacher = query.getResultList();

		if (listteacher.size() == 0)
		{
			return null;
		}
		else
		{
			return listteacher.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TeacherDTO> listTeacher()
	{
		Query query = entityManager.createQuery(JPQL_LIST_TEACHER);
		List<TeacherDTO> listTeacher = query.getResultList();

		return listTeacher;
	}


}
