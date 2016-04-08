package com.fenghui.services.managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.AccessRecordCourseDAO;
import com.fenghui.bases.jpaentities.AccessRecordCourse;
import com.fenghui.bases.jpaentities.Course;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.AccessRecordsCourseService;

public class AccessRecordsCourseManager implements AccessRecordsCourseService
{
	protected IHandleEntity<AccessRecordCourse> handleAccessRecordsCourse;

	EntityManager entityManager;

	private final String JPQL_FIND_ACCESSRECORDSCOURSE = "select e from AccessRecordsCourse e where e.id=:id";
	private final String JPQL_COUNT_BY_COURSEID = "select count(e) from AccessRecordsCourse e where e.course=:courseId";
	private final String JPQL_FIND_ACCESSRECORDSCOURSES = "select e from AccessRecordsCourse e";

	public AccessRecordsCourseManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public boolean addAccessRecordsCourse(AccessRecordCourse accessRecordsCourse)
	{
		handleAccessRecordsCourse = new AccessRecordCourseDAO(entityManager);
		handleAccessRecordsCourse.addEntity(accessRecordsCourse);
		handleAccessRecordsCourse.close();
		return true;
	}

	@Override
	@Transactional
	public boolean modifyAccessRecordsCourse(AccessRecordCourse accessRecordsCourse)
	{
		handleAccessRecordsCourse = new AccessRecordCourseDAO(entityManager);
		handleAccessRecordsCourse.modifyEntity(accessRecordsCourse);
		handleAccessRecordsCourse.close();
		return false;
	}

	@Override
	@Transactional
	public boolean removeAccessRecordsCourse(AccessRecordCourse accessRecordsCourse)
	{
		handleAccessRecordsCourse = new AccessRecordCourseDAO(entityManager);
		handleAccessRecordsCourse.deleteEntity(accessRecordsCourse);
		handleAccessRecordsCourse.close();
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public AccessRecordCourse findAccessRecordsCourse(AccessRecordCourse accessRecordsCourse)
	{
		Query query = entityManager.createQuery(JPQL_FIND_ACCESSRECORDSCOURSE);
		query.setParameter("id", accessRecordsCourse.getId());
		List<AccessRecordCourse> accessRecordsCourses = query.getResultList();

		if (accessRecordsCourses.size() == 0)
		{
			return null;
		}
		else
		{
			return (AccessRecordCourse) accessRecordsCourses.get(0);
		}
	}
	
	@Override
	public int accessRecordsCourseCountByCourseId(Course course)
	{
		Query query = entityManager.createQuery(JPQL_COUNT_BY_COURSEID);
		query.setParameter("courseId", course.getId());
		Object result = query.getSingleResult();
		return Integer.parseInt(result.toString());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AccessRecordCourse> listAccessRecordsCourse()
	{
		Query query = entityManager.createQuery(JPQL_FIND_ACCESSRECORDSCOURSES);
		List<AccessRecordCourse> accessRecordsCourses = query.getResultList();

		return accessRecordsCourses;
	}
}
