package com.fenghui.services.managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.CourseDAO;
import com.fenghui.bases.jpadtos.CourseListDTO;
import com.fenghui.bases.jpaentities.Course;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.CourseService;

public class CourseManager implements CourseService
{
	protected IHandleEntity<Course> handleCourse;

	EntityManager entityManager;

	private final String JPQL_FIND_COURSE = "select e from Course e where e.id=:id";
	private final String JPQL_COURSE_LIST = "select e from Course e";
	private final String JPQL_FIND_COURSESS = "select e from Course e where e.ownerId = :teacherId";
	private final String JQOL_FIND_COURSE_ACCESSRECORD = "select new com.fenghui.bases.jpadtos.CourseListDTO("
			+ "c.title,c.isCharged,c.price,c.coverpageLocation,(select count(a.id) from AccessRecordCourseDTO a "
			+ "where  a.coursesDTO.id = c.id)) " + "from Course c where c.ownerId = :teacherId";
	private final String JQOL_FIND_TOP_COURSE = "select new com.fenghui.bases.jpadtos.CourseListDTO("
			+ "c.title,c.isCharged,c.price,c.coverpageLocation,max(select count(a.id) from AccessRecordCourseDTO a "
			+ "where  a.coursesDTO.id = c.id)) " + "from Course c where c.ownerId = :teacherId";

	public CourseManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public boolean addCourse(Course course)
	{
		System.out.println("access manager");
		handleCourse = new CourseDAO(entityManager);
		handleCourse.addEntity(course);
		handleCourse.close();
		return true;
	}

	@Override
	@Transactional
	public boolean modifyCourse(Course courses)
	{
		handleCourse = new CourseDAO(entityManager);
		handleCourse.modifyEntity(courses);
		handleCourse.close();
		return false;
	}

	@Override
	@Transactional
	public boolean removeCourse(Course course)
	{
		handleCourse = new CourseDAO(entityManager);
		handleCourse.deleteEntity(course);
		handleCourse.close();
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Course findCourse(Course course)
	{
		Query query = entityManager.createQuery(JPQL_FIND_COURSE);
		query.setParameter("id", course.getId());
		List<Course> Coursess = query.getResultList();

		if (Coursess.size() == 0)
		{
			return null;
		}
		else
		{
			return (Course) Coursess.get(0);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Course> courseList()
	{
		Query query = entityManager.createQuery(JPQL_COURSE_LIST);
		List<Course> courseList = query.getResultList();
		return courseList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CourseListDTO> findCourseList(int teacherId)
	{
		Query query = entityManager.createQuery(JQOL_FIND_COURSE_ACCESSRECORD);
		query.setParameter("teacherId", teacherId);
		List<CourseListDTO> courseAccessRecord = query.getResultList();
		System.out.println(courseAccessRecord);

		return courseAccessRecord;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Course> listCourse(int teacherId)
	{
		Query query = entityManager.createQuery(JPQL_FIND_COURSESS);
		query.setParameter("teacherId", teacherId);
		List<Course> courses = query.getResultList();
		return courses;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CourseListDTO findTopCourse(int teacherId)
	{

		Query query = entityManager.createQuery(JQOL_FIND_TOP_COURSE);
		query.setParameter("teacherId", teacherId);
		List<CourseListDTO> Coursess = query.getResultList();

		if (Coursess.size() == 0)
		{
			return null;
		}
		else
		{
			return (CourseListDTO) Coursess.get(0);
		}
	}
}
