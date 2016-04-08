package com.fenghui.services.managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.TeacherProductDAO;
import com.fenghui.bases.jpaentities.TeacherProduct;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.TeacherProductService;

public class TeacherProductManager implements TeacherProductService
{
	protected IHandleEntity<TeacherProduct> handleTeachersProduct;

	EntityManager entityManager;
	
	private final String JPQL_FIND_TEACHERPRODUCT = "select e from TEACHERSPRODUCTS e where e.userId=:userId";
	private final String JPQL_LIST_TEACHERPRODUCT = "select e from TEACHERSPRODUCTS e";

	public TeacherProductManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public boolean addTeacherProduct(TeacherProduct teachersProduct)
	{
		handleTeachersProduct = new TeacherProductDAO(entityManager);
		handleTeachersProduct.addEntity(teachersProduct);
		handleTeachersProduct.close();
		return true;
	}

	@Override
	@Transactional
	public boolean removeTeacherProduct(TeacherProduct teacherProduct)
	{
		handleTeachersProduct = new TeacherProductDAO(entityManager);
		handleTeachersProduct.deleteEntity(teacherProduct);
		handleTeachersProduct.close();
		return true;
	}

	@Override
	@Transactional
	public boolean modifyTeacherProduct(TeacherProduct teachersProduct)
	{
		handleTeachersProduct = new TeacherProductDAO(entityManager);
		handleTeachersProduct.modifyEntity(teachersProduct);
		handleTeachersProduct.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TeacherProduct findTeacherProduct(TeacherProduct teacherProduct)
	{
		Query query = entityManager.createQuery(JPQL_FIND_TEACHERPRODUCT);
//		query.setParameter(position, value)
		List<TeacherProduct> listteacherProduct = query.getResultList();
		return listteacherProduct.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TeacherProduct> listTeacherProduct()
	{
		Query query = entityManager.createQuery(JPQL_LIST_TEACHERPRODUCT);
		List<TeacherProduct> listTeacherProduct = query.getResultList();
		return listTeacherProduct;
	}

}
