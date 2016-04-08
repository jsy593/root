package com.fenghui.framework.services;

import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpaentities.NewsType;

public interface NewsTypeService
{
	@Transactional
	public boolean addNewsType(NewsType newsType);
	
	@Transactional
	public boolean removeNewsType(NewsType newsType);
	
	@Transactional
	public boolean modifyNewsType(NewsType newsType);
	
	public NewsType findNewsType(NewsType newsType);
	
	public List<NewsType> listNewsType();
}
