package com.fenghui.framework.services;


import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpaentities.UserProduct;

public interface UserProductService
{
	@Transactional
	public boolean addUserProduct(UserProduct userProduct);
	
	@Transactional
	public boolean removeUserProduct(UserProduct userProduct);
	
	@Transactional
	public boolean modifyUserProduct(UserProduct userProduct);
	
	public UserProduct findUserProduct(UserProduct userProduct);
	
	public List<UserProduct> listUserProduct();
	
}
