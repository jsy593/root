package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fenghui.bases.jpadtos.InformationDTO;
import com.fenghui.bases.jpadtos.TeacherDTO;
import com.fenghui.bases.jpadtos.ViewpointDTO;
import com.fenghui.bases.jpaentities.Course;
import com.fenghui.bases.jpaentities.Information;
import com.fenghui.bases.jpaentities.News;
import com.fenghui.bases.jpaentities.Room;
import com.fenghui.bases.jpaentities.Teacher;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.CourseService;
import com.fenghui.framework.services.InformationService;
import com.fenghui.framework.services.NewsService;
import com.fenghui.framework.services.RoomService;
import com.fenghui.framework.services.TeacherService;
import com.fenghui.framework.services.ViewPointService;
import com.fenghui.services.managers.CourseManager;
import com.fenghui.services.managers.InformationManager;
import com.fenghui.services.managers.NewsManager;
import com.fenghui.services.managers.RoomManager;
import com.fenghui.services.managers.TeacherManager;
import com.fenghui.services.managers.ViewPointManager;

public class RoomBean extends BeanBase implements Serializable
{

	private static final long serialVersionUID = 2282104649108770454L;
	
	public boolean addRoom(Room room)
	{
		RoomService roomsService = getProxyRoomService();
		roomsService.addRoom(room);
		return true;
	}
	
	public boolean cancelRoom(Room room)
	{
		RoomService roomService = getProxyRoomService();
		room =findRoom(room);
		return roomService.cancelRoom(room);
	}
	
	public boolean modifyRoom(Room room)
	{
		RoomService roomService = getProxyRoomService();
		return roomService.modifyRoom(room);
	}
	
	public Room findRoom(Room room)
	{
		RoomService roomService = getProxyRoomService();
		return roomService.findRoom(room);
	}

	public List<Room> listRoom()
	{
		RoomService roomService = getProxyRoomService();
		return roomService.listRoom();
	}
	
	
	private RoomService getProxyRoomService()
	{
		RoomService RoomManager = new RoomManager(entityManager);
		RoomService roomServiceProxy = (RoomService) (jpaTransactionalProxyManager).proxyFor(RoomManager);
		return roomServiceProxy;
	}

	
	public boolean addInformation(Information information)
	{
		InformationService informationService = getProxyInformationsService();
		informationService.addInformation(information);
		return true;
	}

	public boolean modifyInformation(Information information)
	{
		InformationService informationService = getProxyInformationsService();
		return informationService.modifyInformation(information);
	}

	public boolean removeInformation(Information information)
	{
		InformationService informationService = getProxyInformationsService();
		return informationService.removeInformation(information);
	}

	public Information findInformation(Information information)
	{
		InformationService informationService = getProxyInformationsService();
		return informationService.findInformation(information);
	}

	public List<InformationDTO> listInformation(int teacherId)
	{
		InformationService informationService = getProxyInformationsService();
		return informationService.listInformation(teacherId);
	}

	private InformationService getProxyInformationsService()
	{
		InformationService informationsManager = new InformationManager(entityManager);
		InformationService informationsServiceProxy = (InformationService) (jpaTransactionalProxyManager)
				.proxyFor(informationsManager);

		return informationsServiceProxy;
	}
	
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

	public List<Course> listCourse()
	{
		CourseService courseService = getProxyCoursesService();
		return courseService.courseList();
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
	
	
	public boolean addViewPoint(ViewpointDTO viewPointDto)
	{
		ViewPointService viewPointService = getProxyViewPointService();
		viewPointService.addViewPoint(viewPointDto);
		return true;
	}
	
	public boolean cancelUser(ViewpointDTO viewPointDto)
	{
		ViewPointService viewPointService = getProxyViewPointService();
		viewPointDto =findViewPoint(viewPointDto);
		return viewPointService.cancelViewPoint(viewPointDto);
	}
	
	public boolean modifyUser(ViewpointDTO viewPointDto)
	{
		ViewPointService viewPointService = getProxyViewPointService();
		return viewPointService.modifyViewPoint(viewPointDto);
	}
	
	public ViewpointDTO findViewPoint(ViewpointDTO viewPointDto)
	{
		ViewPointService viewPointService = getProxyViewPointService();
		return viewPointService.findViewPoint(viewPointDto);
	}

	public List<ViewpointDTO> listViewPoint(Teacher teacher)
	{
		ViewPointService viewPointService = getProxyViewPointService();
		return viewPointService.listViewPoint(teacher);
	}
	
	private ViewPointService getProxyViewPointService()
	{
		ViewPointService viewPointManager = new ViewPointManager(entityManager);
		ViewPointService viewPointServiceProxy = (ViewPointService) (jpaTransactionalProxyManager).proxyFor(viewPointManager);
		return viewPointServiceProxy;
	}
	
	
	public boolean registerTeacher(Teacher teachers)
	{
		TeacherService teacherService = getProxyTeacherService();
		return teacherService.addTeacher(teachers);
	}
	
	public boolean modifyTeacher(Teacher teachers)
	{
		TeacherService teacherService = getProxyTeacherService();
		return teacherService.modifyTeacher(teachers);
		
	}

	public boolean cancelTeacher(Teacher teachers)
	{
		TeacherService teacherService = getProxyTeacherService();
		return teacherService.removeTeacher(teachers);
	}

	public Teacher findTeacher(Teacher teacher)
	{
		TeacherService teacherService = getProxyTeacherService();
		return teacherService.findTeacher(teacher);
		
	}
	
	public TeacherDTO findTeacherDTO(Teacher teacher)
	{
		TeacherService teacherService = getProxyTeacherService();
		return teacherService.findTeacherDTO(teacher);
		
	}

	public Teacher loginTeacher(Teacher teacher)
	{
		TeacherService teacherService = getProxyTeacherService();
		return teacherService.loginTeacher(teacher);
		
	}

	public List<TeacherDTO> listTeacher()
	{
		TeacherService teacherService = getProxyTeacherService();
		return teacherService.listTeacher();
	}
	
	private TeacherService getProxyTeacherService()
	{
		TeacherService teacherManager = new TeacherManager(entityManager);
		TeacherService teacherServiceProxy = (TeacherService) (jpaTransactionalProxyManager).proxyFor(teacherManager);
		return teacherServiceProxy;
	}
	
	
	public boolean addNews(News news)
	{
		NewsService newsService = getProxyNewsService();
		return newsService.addNews(news);
	}

	public boolean removeNews(News news)
	{
		NewsService newsService = getProxyNewsService();
		return newsService.removeNews(news);
		
	}

	public boolean modifyNews(News news)
	{
		NewsService newsService = getProxyNewsService();
		return newsService.modifyNews(news);
	}

	public News findNews(News news)
	{
		NewsService newsService = getProxyNewsService();
		return newsService.findNews(news);
	}

	public List<News> listNews()
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
