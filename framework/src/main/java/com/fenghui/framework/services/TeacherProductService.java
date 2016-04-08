package com.fenghui.framework.services;


import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpaentities.TeacherProduct;

public interface TeacherProductService
{
	@Transactional
	public boolean addTeacherProduct(TeacherProduct teacherProduct);
								
	@Transactional
	public boolean removeTeacherProduct(TeacherProduct teacherProduct);
	
	@Transactional
	public boolean modifyTeacherProduct(TeacherProduct teacherProduct);
	
	public TeacherProduct findTeacherProduct(TeacherProduct teacherProduct);
	
	public List<TeacherProduct> listTeacherProduct();

	
}
