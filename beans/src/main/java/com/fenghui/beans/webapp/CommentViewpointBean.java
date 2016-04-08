package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.List;

import com.fenghui.bases.jpaentities.CommentViewpoint;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.CommentViewpointService;
import com.fenghui.services.managers.CommentViewpointManager;

public class CommentViewpointBean extends BeanBase implements Serializable
{
	private static final long serialVersionUID = 7434597687426811196L;
	
	public boolean addCommentViewpoint(CommentViewpoint commentViewpoint)
	{
		CommentViewpointService commentViewpointService = getProxyCommentViewpointService();
		commentViewpointService.addCommentViewpoint(commentViewpoint);
		return true;
	}
	
	public boolean cancelCommentViewpoint(CommentViewpoint commentViewpoint)
	{
		CommentViewpointService commentViewpointService = getProxyCommentViewpointService();
		commentViewpoint =findCommentViewpoint(commentViewpoint);
		return commentViewpointService.cancelCommentViewpoint(commentViewpoint);
	}
	
	public boolean modifyCommentViewpoint(CommentViewpoint commentViewpoint)
	{
		CommentViewpointService commentViewpointService = getProxyCommentViewpointService();
		return commentViewpointService.modifyCommentViewpoint(commentViewpoint);
	}
	
	public CommentViewpoint findCommentViewpoint(CommentViewpoint commentViewpoint)
	{
		CommentViewpointService commentViewpointService = getProxyCommentViewpointService();
		return commentViewpointService.findCommentViewpoint(commentViewpoint);
	}

	public List<CommentViewpoint> listCommentViewpoint()
	{
		CommentViewpointService commentViewpointService = getProxyCommentViewpointService();
		return commentViewpointService.listCommentViewpoint();
	}
	
	
	private CommentViewpointService getProxyCommentViewpointService ()
	{
		CommentViewpointService commentViewpointManager = new CommentViewpointManager(entityManager);
		CommentViewpointService commentViewpointServiceProxy = (CommentViewpointService) (jpaTransactionalProxyManager).proxyFor(commentViewpointManager);
		return commentViewpointServiceProxy;
	}

}
