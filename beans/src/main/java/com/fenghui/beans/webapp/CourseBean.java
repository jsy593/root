package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fenghui.bases.jpaentities.Course;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.CourseService;
import com.fenghui.services.managers.CourseManager;

public class CourseBean extends BeanBase implements Serializable
{
	private static final long serialVersionUID = 1571888601599875144L;

	public boolean addCourse(Course course)
	{
		CourseService coursesService = getProxyCoursesService();
		coursesService.addCourse(course);
		return true;
	}

	public boolean modifyCourse(Course course)
	{
		CourseService courseService = getProxyCoursesService();
		course.setLastModifiedTime(new Date());
		return courseService.modifyCourse(course);
	}

	public boolean removeCourse(Course course) {
		CourseService courseService = getProxyCoursesService();
		courseService.removeCourse(course);
		return true;
	}
	
	public Course findCourse(Course course)
	{
		CourseService courseService = getProxyCoursesService();
		return courseService.findCourse(course);
	}

	public List<Course> listCourse(int teacherId)
	{
		CourseService courseService = getProxyCoursesService();
		return courseService.listCourse(teacherId);
	}

	private CourseService getProxyCoursesService()
	{
		CourseService coursesManager = new CourseManager(entityManager);
		CourseService coursesServiceProxy = (CourseService) (jpaTransactionalProxyManager).proxyFor(coursesManager);

		return coursesServiceProxy;
	}
	
}
