package com.fenghui.framework.services;

import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpaentities.CommentViewpoint;

public interface CommentViewpointService
{
	@Transactional
	public boolean addCommentViewpoint(CommentViewpoint commentViewpoint);
	
	@Transactional
	public boolean cancelCommentViewpoint(CommentViewpoint commentViewpoint);
		
	@Transactional
	public boolean modifyCommentViewpoint(CommentViewpoint commentViewpoint);
	
	public CommentViewpoint findCommentViewpoint(CommentViewpoint commentViewpoint);
	
	public List<CommentViewpoint> listCommentViewpoint();
}
