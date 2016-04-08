package com.fenghui.stockconsultant.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.fenghui.bases.handlejpa.ControllerBase;
import com.fenghui.bases.jpadtos.CourseListDTO;
import com.fenghui.bases.jpaentities.News;
import com.fenghui.beans.webapp.CourseListBean;

@ManagedBean(name = "courseListController")
@SessionScoped
public class CourseListController extends ControllerBase implements Serializable
{
	private static final long serialVersionUID = -9179948272113963545L;
	
	CourseListBean courseListBean = new CourseListBean();
	private List<CourseListDTO> courseList = courseListBean.findCourseList(1);
	private List<News> newsList = courseListBean.findNewsList();
	private CourseListDTO topCourse = courseListBean.findTopCourse(1);
	
	public CourseListBean getCourseListBean()
	{
		return courseListBean;
	}
	public void setCourseListBean(CourseListBean courseListBean)
	{
		this.courseListBean = courseListBean;
	}
	public List<CourseListDTO> getCourseList()
	{
		return courseList;
	}
	public void setCourseList(List<CourseListDTO> courseList)
	{
		this.courseList = courseList;
	}
	public List<News> getNewsList()
	{
		return newsList;
	}
	public void setNewsList(List<News> newsList)
	{
		this.newsList = newsList;
	}
	public CourseListDTO getTopCourse()
	{
		return topCourse;
	}
	public void setTopCourse(CourseListDTO topCourse)
	{
		this.topCourse = topCourse;
	}
	
	
}
