package com.fenghui.framework.services;

import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadtos.TeacherDTO;
import com.fenghui.bases.jpaentities.Teacher;

public interface TeacherService
{
	@Transactional
	public boolean addTeacher(Teacher teacher);
	
	@Transactional
	public boolean removeTeacher(Teacher teacher);
	
	@Transactional
	public boolean modifyTeacher(Teacher teacher);
	
	public Teacher findTeacher(Teacher teacher);
	
	public TeacherDTO findTeacherDTO(Teacher teacher);
	
	public Teacher loginTeacher(Teacher teacher);
	
	public List<TeacherDTO> listTeacher();

}
