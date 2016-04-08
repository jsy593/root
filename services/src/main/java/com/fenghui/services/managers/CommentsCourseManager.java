package com.fenghui.services.managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.CommentCourseDAO;
import com.fenghui.bases.jpaentities.CommentCourse;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.CommentsCourseService;

public class CommentsCourseManager implements CommentsCourseService
{
	protected IHandleEntity<CommentCourse> handleCommentsCourse;

	EntityManager entityManager;

	private final String JPQL_FIND_COMMENTSCOURSE = "select e from CommentsCourse e where e.id=:id";
	private final String JPQL_FIND_COMMENTSCOURSES = "select e from CommentsCourse e";

	public CommentsCourseManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public boolean addCommentsCourse(CommentCourse commentsCourse)
	{
		handleCommentsCourse = new CommentCourseDAO(entityManager);
		handleCommentsCourse.addEntity(commentsCourse);
		handleCommentsCourse.close();
		return true;
	}

	@Override
	@Transactional
	public boolean modifyCommentsCourse(CommentCourse commentsCourse)
	{
		handleCommentsCourse = new CommentCourseDAO(entityManager);
		handleCommentsCourse.modifyEntity(commentsCourse);
		handleCommentsCourse.close();
		return false;
	}

	@Override
	@Transactional
	public boolean removeCommentsCourse(CommentCourse commentsCourse)
	{
		handleCommentsCourse = new CommentCourseDAO(entityManager);
		handleCommentsCourse.deleteEntity(commentsCourse);
		handleCommentsCourse.close();
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public CommentCourse findCommentsCourse(CommentCourse commentsCourse)
	{
		Query query = entityManager.createQuery(JPQL_FIND_COMMENTSCOURSE);
		query.setParameter("id", commentsCourse.getId());
		List<CommentCourse> CommentsCourses = query.getResultList();

		if (CommentsCourses.size() == 0)
		{
			return null;
		}
		else
		{
			return (CommentCourse) CommentsCourses.get(0);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CommentCourse> listCommentsCourse()
	{
		Query query = entityManager.createQuery(JPQL_FIND_COMMENTSCOURSES);
		List<CommentCourse> CommentsCourses = query.getResultList();

		return CommentsCourses;
	}
}