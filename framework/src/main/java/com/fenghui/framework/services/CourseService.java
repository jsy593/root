package com.fenghui.framework.services;

import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadtos.CourseListDTO;
import com.fenghui.bases.jpaentities.Course;

public interface CourseService
{
	@Transactional
	public boolean addCourse(Course course);

	@Transactional
	public boolean modifyCourse(Course course);

	@Transactional
	public boolean removeCourse(Course course);

	public Course findCourse(Course course);

	public List<Course> courseList();
	
	public List<CourseListDTO> findCourseList(int teacherId);
	
	public List<Course> listCourse(int teacherId);

	public CourseListDTO findTopCourse(int teacherId);
}
