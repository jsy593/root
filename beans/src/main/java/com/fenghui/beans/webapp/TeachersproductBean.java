package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.List;

import com.fenghui.bases.jpaentities.TeacherProduct;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.TeacherProductService;
import com.fenghui.services.managers.TeacherProductManager;

public class TeachersproductBean extends BeanBase implements Serializable
{
	
	private static final long serialVersionUID = 5715893215011242619L;

	public boolean addTeachersProducts(TeacherProduct teacherProduct){
		TeacherProductService teachersProductService = getProxyTeacherProductService();
		return teachersProductService.addTeacherProduct(teacherProduct);
	}
	
	public boolean removeTeachersProducts(TeacherProduct teacherProduct){
		TeacherProductService teacherProductService = getProxyTeacherProductService();
		return teacherProductService.removeTeacherProduct(teacherProduct);
	}
	
	public boolean modifyTeachersProducts(TeacherProduct teacherProduct){
		TeacherProductService teacherProductService = getProxyTeacherProductService();
		return teacherProductService.modifyTeacherProduct(teacherProduct);
	}
	
	public TeacherProduct findTeachersProducts(TeacherProduct teacherProduct){
		TeacherProductService teacherProductService = getProxyTeacherProductService();
		return teacherProductService.findTeacherProduct(teacherProduct);
	}
	
	public List<TeacherProduct> listTeachersProducts(){
		TeacherProductService teacherProductService = getProxyTeacherProductService();
		return teacherProductService.listTeacherProduct();
	}
	
	
	private TeacherProductService getProxyTeacherProductService()
	{
		TeacherProductService teacherProductService = new TeacherProductManager(entityManager);
		TeacherProductService teacherProductServiceProxy = (TeacherProductService) (jpaTransactionalProxyManager).proxyFor(teacherProductService);
		return teacherProductServiceProxy;
	}

}
