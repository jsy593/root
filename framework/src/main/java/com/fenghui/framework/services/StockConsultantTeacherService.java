package com.fenghui.framework.services;

import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpaentities.StockConsultantTeacher;

public interface StockConsultantTeacherService
{
	@Transactional
	public boolean addStockConsultantTeacher(StockConsultantTeacher stockConsultantTeacher);

	@Transactional
	public boolean modifyStockConsultantTeacher(StockConsultantTeacher stockConsultantTeacher);

	@Transactional
	public boolean removeStockConsultantTeacher(StockConsultantTeacher stockConsultantTeacher);

	public StockConsultantTeacher findStockConsultantTeacher(StockConsultantTeacher stockConsultantTeacher);

	public List<StockConsultantTeacher> listStockConsultantTeachers();

}
