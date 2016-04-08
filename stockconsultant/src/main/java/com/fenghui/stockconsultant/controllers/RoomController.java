package com.fenghui.stockconsultant.controllers;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.fenghui.bases.handlejpa.ControllerBase;
import com.fenghui.bases.jpadtos.InformationDTO;
import com.fenghui.bases.jpadtos.TeacherDTO;
import com.fenghui.bases.jpadtos.ViewpointDTO;
import com.fenghui.bases.jpaentities.Course;
import com.fenghui.bases.jpaentities.News;
import com.fenghui.bases.jpaentities.Room;
import com.fenghui.bases.jpaentities.Teacher;
import com.fenghui.beans.webapp.RoomBean;


@ManagedBean(name = "roomController")
@SessionScoped
public class RoomController extends ControllerBase implements Serializable
{
	private static final long serialVersionUID = 522228648856175184L;
	RoomBean roomBean = new RoomBean();

	private List<InformationDTO> informationList = null;

	private Course course = new Course();
	private Course updatingCourse = new Course();
	private List<Course> courseList = null;

	Teacher teacherView = new Teacher();
	private List<ViewpointDTO> viewPonitlist = roomBean.listViewPoint(teacherView);

	private List<TeacherDTO> teacherList = roomBean.listTeacher();
	private Teacher teacher = new Teacher();
	private TeacherDTO teacherDTO = new TeacherDTO();

	private News news = new News();
	private News updatingNews = new News();
	private List<News> newsList = null;

	private Room room = new Room();

	private int teacherId = 0;
	private int roomId = 0;

	public String accessRoomInstall()
	{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		Map<String, String> params = externalContext.getRequestParameterMap();
		teacherId = Integer.parseInt(params.get("teacherId"));
		roomId = Integer.parseInt(params.get("roomId"));

		informationList = roomBean.listInformation(teacherId);

		courseList = roomBean.listCourse(teacherId);
		
		teacher.setId(teacherId);
		teacherDTO = roomBean.findTeacherDTO(teacher);

		newsList = roomBean.listNews();
		
		room.setId(roomId);
		room = roomBean.findRoom(room);

		return "stock2.xhtml";
	}

	public String listCourse()
	{
		courseList = roomBean.listCourse(teacherId);
		return "stock2.xhtml";
	}

	public String listViewPonit()
	{
		setViewPonitlist(roomBean.listViewPoint(teacherView));
		return "/users/listInformations.xhtml";
	}

	public Course getCourse()
	{
		return course;
	}

	public void setCourse(Course course)
	{
		this.course = course;
	}

	public Course getUpdatingCourse()
	{
		return updatingCourse;
	}

	public void setUpdatingCourse(Course updatingCourse)
	{
		this.updatingCourse = updatingCourse;
	}

	public List<Course> getCourseList()
	{
		return courseList;
	}

	public void setCourseList(List<Course> courseList)
	{
		this.courseList = courseList;
	}

	public Teacher getTeacherView()
	{
		return teacherView;
	}

	public void setTeacherView(Teacher teacherView)
	{
		this.teacherView = teacherView;
	}

	public List<ViewpointDTO> getViewPonitlist()
	{
		return viewPonitlist;
	}

	public void setViewPonitlist(List<ViewpointDTO> viewPonitlist)
	{
		this.viewPonitlist = viewPonitlist;
	}

	public List<TeacherDTO> getTeacherList()
	{
		return teacherList;
	}

	public void setTeacherList(List<TeacherDTO> teacherList)
	{
		this.teacherList = teacherList;
	}

	public Teacher getTeacher()
	{
		return teacher;
	}

	public void setTeacher(Teacher teacher)
	{
		this.teacher = teacher;
	}

	public TeacherDTO getTeacherDTO()
	{
		return teacherDTO;
	}

	public void setTeacherDTO(TeacherDTO teacherDTO)
	{
		this.teacherDTO = teacherDTO;
	}

	public News getNews()
	{
		return news;
	}

	public void setNews(News news)
	{
		this.news = news;
	}

	public News getUpdatingNews()
	{
		return updatingNews;
	}

	public void setUpdatingNews(News updatingNews)
	{
		this.updatingNews = updatingNews;
	}

	public List<News> getNewsList()
	{
		return newsList;
	}

	public void setNewsList(List<News> newsList)
	{
		this.newsList = newsList;
	}

	public List<InformationDTO> getInformationList()
	{
		return informationList;
	}

	public void setInformationList(List<InformationDTO> informationList)
	{
		this.informationList = informationList;
	}

	public Room getRoom()
	{
		return room;
	}

	public void setRoom(Room room)
	{
		this.room = room;
	}
}
