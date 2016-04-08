package com.fenghui.framework.services;

import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpaentities.CommentCourse;

public interface CommentsCourseService
{
	@Transactional
	public boolean addCommentsCourse(CommentCourse commentsCourse);

	@Transactional
	public boolean modifyCommentsCourse(CommentCourse commentsCourse);

	@Transactional
	public boolean removeCommentsCourse(CommentCourse commentsCourse);

	public CommentCourse findCommentsCourse(CommentCourse commentsCourse);

	public List<CommentCourse> listCommentsCourse();
	
}
