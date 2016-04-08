package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.List;

import com.fenghui.bases.jpaentities.Product;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.ProductsService;
import com.fenghui.services.managers.ProductManager;

public class ProductsBean extends BeanBase implements Serializable
{

	private static final long serialVersionUID = -7993765169656668588L;
	
	public boolean addProducts(Product products){
		ProductsService productsService = getProxyProductsService();
		return productsService.addProducts(products);
	}
	
	public boolean removeProducts(Product products){
		ProductsService productsService = getProxyProductsService();
		return productsService.removeProducts(products);
	}
	
	public boolean modifyProducts(Product products){
		ProductsService productsService = getProxyProductsService();
		return productsService.modifyProducts(products);
	}

	
	public Product findProducts(Product products){
		ProductsService productsService = getProxyProductsService();
		return productsService.findProducts(products);
	}
	
	public List<Product> listProducts(){
		ProductsService productsService = getProxyProductsService();
		return productsService.listProducts();
	}
	
	private ProductsService getProxyProductsService()
	{
		ProductsService productsManager = new ProductManager(entityManager);
		ProductsService productsServiceProxy = (ProductManager) (jpaTransactionalProxyManager).proxyFor(productsManager);
		return productsServiceProxy;
	}
}
