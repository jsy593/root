package com.fenghui.services.managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.StockConsultantTeacherDAO;
import com.fenghui.bases.jpaentities.StockConsultantTeacher;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.StockConsultantTeacherService;

public class StockConsultantTeacherManager implements StockConsultantTeacherService
{
	protected IHandleEntity<StockConsultantTeacher> handleStockConsultantTeacher;

	EntityManager entityManager;

	private final String JPQL_FIND_STOCKCONSULTANTTEACHER = "select e from StockConsultantTeacher e where e.id=:id";
	private final String JPQL_LIST_STOCKCONSULTANTTEACHERS = "select e from StockConsultantTeacher e";

	public StockConsultantTeacherManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public boolean addStockConsultantTeacher(StockConsultantTeacher stockConsultantTeacher)
	{
		handleStockConsultantTeacher = new StockConsultantTeacherDAO(entityManager);
		handleStockConsultantTeacher.addEntity(stockConsultantTeacher);
		handleStockConsultantTeacher.close();
		return true;
	}

	@Override
	@Transactional
	public boolean modifyStockConsultantTeacher(StockConsultantTeacher stockConsultantTeacher)
	{
		handleStockConsultantTeacher = new StockConsultantTeacherDAO(entityManager);
		handleStockConsultantTeacher.modifyEntity(stockConsultantTeacher);
		handleStockConsultantTeacher.close();
		return true;
	}

	@Override
	@Transactional
	public boolean removeStockConsultantTeacher(StockConsultantTeacher stockConsultantTeacher)
	{
		handleStockConsultantTeacher = new StockConsultantTeacherDAO(entityManager);
		handleStockConsultantTeacher.deleteEntity(stockConsultantTeacher);
		handleStockConsultantTeacher.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public StockConsultantTeacher findStockConsultantTeacher(StockConsultantTeacher stockConsultantTeacher)
	{
		Query query = entityManager.createQuery(JPQL_FIND_STOCKCONSULTANTTEACHER);
		query.setParameter("id", stockConsultantTeacher.getId());
		List<StockConsultantTeacher> stockConsultantTeachers = query.getResultList();

		if (stockConsultantTeachers.size() == 0)
		{
			return null;
		}
		else
		{
			return (StockConsultantTeacher) stockConsultantTeachers.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StockConsultantTeacher> listStockConsultantTeachers()
	{
		Query query = entityManager.createQuery(JPQL_LIST_STOCKCONSULTANTTEACHERS);
		List<StockConsultantTeacher> stockConsultantTeachers = query.getResultList();

		return stockConsultantTeachers;
	}
}
