package com.fenghui.framework.services;

import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpaentities.TeacherOtherLink;

public interface TeacherOtherLinkService
{
	@Transactional
	public boolean addTeacherOtherLink(TeacherOtherLink teacherOtherLink);
								
	@Transactional
	public boolean removeTeacherOtherLink(TeacherOtherLink teacherOtherLink);
	
	@Transactional
	public boolean modifyTeacherOtherLink(TeacherOtherLink teacherOtherLink);
	
	public TeacherOtherLink findTeacherOtherLink(TeacherOtherLink teacherOtherLink);
	
	public List<TeacherOtherLink> listTeacherOtherLink();

}
