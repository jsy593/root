package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.List;

import com.fenghui.bases.jpadtos.CourseListDTO;
import com.fenghui.bases.jpaentities.Course;
import com.fenghui.bases.jpaentities.News;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.CourseService;
import com.fenghui.framework.services.NewsService;
import com.fenghui.services.managers.CourseManager;
import com.fenghui.services.managers.NewsManager;

public class CourseListBean extends BeanBase implements Serializable
{

	private static final long serialVersionUID = -1306398471522875911L;
	
	public List<Course> courseList()
	{
		CourseService courseService = getProxyCoursesService();
		return courseService.courseList();
	}
	
	public List<CourseListDTO> findCourseList(int teacherId)
	{
		CourseService courseService = getProxyCoursesService();
		return courseService.findCourseList(teacherId);
	}
	
	public CourseListDTO findTopCourse(int teacherId)
	{
		CourseService courseService = getProxyCoursesService();
		return courseService.findTopCourse(teacherId);
	}

	private CourseService getProxyCoursesService()
	{
		CourseService coursesManager = new CourseManager(entityManager);
		CourseService coursesServiceProxy = (CourseService) (jpaTransactionalProxyManager).proxyFor(coursesManager);

		return coursesServiceProxy;
	}
	
	public List<News> findNewsList()
	{
		NewsService newsService = getProxyNewsService();
		return newsService.listNews();
	}
	
	private NewsService getProxyNewsService()
	{
		NewsService newsManager = new NewsManager(entityManager);
		NewsService newsServiceProxy = (NewsService) (jpaTransactionalProxyManager).proxyFor(newsManager);

		return newsServiceProxy;
	}

}
