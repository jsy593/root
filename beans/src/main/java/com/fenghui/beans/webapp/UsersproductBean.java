package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.List;

import com.fenghui.bases.jpaentities.UserProduct;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.UserProductService;
import com.fenghui.services.managers.UserProductManager;

public class UsersproductBean extends BeanBase implements Serializable
{
	
	private static final long serialVersionUID = 5715893215011242619L;

	public boolean addUserProduct(UserProduct userProduct){
		UserProductService userProductService = getProxyUserProductService();
		return userProductService.addUserProduct(userProduct);
	}
	
	public boolean removeUserProduct(UserProduct userProduct){
		UserProductService userProductService = getProxyUserProductService();
		return userProductService.removeUserProduct(userProduct);
	}
	
	public boolean modifyUsersProducts(UserProduct userProduct){
		UserProductService userProductService = getProxyUserProductService();
		return userProductService.modifyUserProduct(userProduct);
	}
	
	public UserProduct findUsersProducts(UserProduct userProduct){
		UserProductService userProductService = getProxyUserProductService();
		return userProductService.findUserProduct(userProduct);
	}
	
	public List<UserProduct> listUserProduct(){
		UserProductService usersProductService = getProxyUserProductService();
		return usersProductService.listUserProduct();
	}
	
	
	private UserProductService getProxyUserProductService()
	{
		UserProductService usersProductService = new UserProductManager(entityManager);
		UserProductService usersProductServiceProxy = (UserProductService) (jpaTransactionalProxyManager).proxyFor(usersProductService);
		return usersProductServiceProxy;
	}

}
