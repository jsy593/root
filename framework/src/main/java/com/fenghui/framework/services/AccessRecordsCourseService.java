package com.fenghui.framework.services;

import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpaentities.AccessRecordCourse;
import com.fenghui.bases.jpaentities.Course;

public interface AccessRecordsCourseService
{
	@Transactional
	public boolean addAccessRecordsCourse(AccessRecordCourse accessRecordsCourse);

	@Transactional
	public boolean modifyAccessRecordsCourse(AccessRecordCourse accessRecordsCourse);

	@Transactional
	public boolean removeAccessRecordsCourse(AccessRecordCourse accessRecordsCourse);

	public AccessRecordCourse findAccessRecordsCourse(AccessRecordCourse accessRecordsCourse);

	public List<AccessRecordCourse> listAccessRecordsCourse();
	
	public int accessRecordsCourseCountByCourseId(Course course);
}
