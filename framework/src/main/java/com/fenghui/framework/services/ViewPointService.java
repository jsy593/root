package com.fenghui.framework.services;

import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadtos.ViewpointDTO;
import com.fenghui.bases.jpaentities.Teacher;
import com.fenghui.bases.jpaentities.ViewPoint;

public interface ViewPointService{

	@Transactional
	public boolean addViewPoint(ViewpointDTO viewPointDto);
	
	@Transactional
	public boolean cancelViewPoint(ViewpointDTO viewPointDto);
	
	@Transactional
	public boolean modifyViewPoint(ViewpointDTO viewPointDto);
	
	public ViewpointDTO findViewPoint(ViewpointDTO viewPointDto);
	
	public List<ViewpointDTO> listViewPoint(Teacher teacher);

}
