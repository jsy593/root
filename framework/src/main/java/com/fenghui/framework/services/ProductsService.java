package com.fenghui.framework.services;


import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpaentities.Product;

public interface ProductsService
{
	@Transactional
	public boolean addProducts(Product products);
	
	@Transactional
	public boolean removeProducts(Product products);
	
	@Transactional
	public boolean modifyProducts(Product products);
	
	public Product findProducts(Product products);
	
	public List<Product> listProducts();

}
