package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.List;

import com.fenghui.bases.jpaentities.CommentCourse;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.CommentsCourseService;
import com.fenghui.services.managers.CommentsCourseManager;

public class CommentsCourseBean extends BeanBase implements Serializable
{

	private static final long serialVersionUID = 2987798301594673400L;

	public boolean addCommentsCourse(CommentCourse commentsCourse)
	{
		CommentsCourseService commentsCourseService = getProxyCommentsCourseService();
		commentsCourseService.addCommentsCourse(commentsCourse);
		return true;
	}

	public boolean modifyCommentsCourse(CommentCourse commentsCourse)
	{
		CommentsCourseService commentsCourseService = getProxyCommentsCourseService();
		return commentsCourseService.modifyCommentsCourse(commentsCourse);
	}

	public boolean removeCommentsCourse(CommentCourse commentsCourse) {
		CommentsCourseService commentsCourseService = getProxyCommentsCourseService();
		commentsCourseService.removeCommentsCourse(commentsCourse);
		return true;
	}
	
	public CommentCourse findCommentsCourse(CommentCourse commentsCourse)
	{
		CommentsCourseService commentsCourseService = getProxyCommentsCourseService();
		return commentsCourseService.findCommentsCourse(commentsCourse);
	}

	public List<CommentCourse> listCommentsCourses()
	{
		CommentsCourseService commentsCourseService = getProxyCommentsCourseService();
		return commentsCourseService.listCommentsCourse();
	}

	private CommentsCourseService getProxyCommentsCourseService()
	{
		CommentsCourseService commentsCourseManager = new CommentsCourseManager(entityManager);
		CommentsCourseService commentsCourseServiceProxy = (CommentsCourseService) (jpaTransactionalProxyManager)
				.proxyFor(commentsCourseManager);

		return commentsCourseServiceProxy;
	}
}
