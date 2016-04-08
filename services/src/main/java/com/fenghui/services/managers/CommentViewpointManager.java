package com.fenghui.services.managers;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.CommentViewpointDAO;
import com.fenghui.bases.jpaentities.CommentViewpoint;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.CommentViewpointService;

public class CommentViewpointManager implements CommentViewpointService
{

	protected IHandleEntity<CommentViewpoint> handleCommentViewpoint;

	EntityManager entityManager;
	
	private final String JPQL_FIND_COMMENTSVIEWPOINT = "select e from CommentViewpoint e where e.id=:id";
	private final String JPQL_LIST_COMMENTSVIEWPOINT = "select e from CommentViewpoint e";

	public CommentViewpointManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public boolean addCommentViewpoint(CommentViewpoint commentsViewpoint)
	{

		handleCommentViewpoint = new CommentViewpointDAO(entityManager);
		commentsViewpoint.setCreateTime(new Date());
		commentsViewpoint.setLastModifiedTime(new Date());
		handleCommentViewpoint.addEntity(commentsViewpoint);
		handleCommentViewpoint.close();
		return true;
	}

	@Override
	@Transactional
	public boolean cancelCommentViewpoint(CommentViewpoint commentsViewpoint)
	{

		handleCommentViewpoint = new CommentViewpointDAO(entityManager);
		handleCommentViewpoint.deleteEntity(commentsViewpoint);
		handleCommentViewpoint.close();
		return true;
	}

	@Override
	@Transactional
	public boolean modifyCommentViewpoint(CommentViewpoint commentViewpoint)
	{
		handleCommentViewpoint = new CommentViewpointDAO(entityManager);
		commentViewpoint.setLastModifiedTime(new Date());
		handleCommentViewpoint.modifyEntity(commentViewpoint);
		handleCommentViewpoint.close();
		return true;
	}
	@SuppressWarnings("unchecked")
	@Override
	public CommentViewpoint findCommentViewpoint(CommentViewpoint commentViewpoint)
	{
		Query query = entityManager.createQuery(JPQL_FIND_COMMENTSVIEWPOINT);
		query.setParameter("id", commentViewpoint.getId());
		List<CommentViewpoint> viewpoint = query.getResultList();
		if (viewpoint.size() == 0)
		{
			return null;
		}
		else
		{
			return (CommentViewpoint) viewpoint.get(0);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<CommentViewpoint> listCommentViewpoint()
	{

		Query query = entityManager.createQuery(JPQL_LIST_COMMENTSVIEWPOINT);
		List<CommentViewpoint> commentsviewpoints = query.getResultList();
		return commentsviewpoints;
	}

}
