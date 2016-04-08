package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fenghui.bases.jpaentities.User;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.UserService;
import com.fenghui.services.managers.UserManager;

public class UserBean extends BeanBase implements Serializable
{

	private static final long serialVersionUID = 6310917381899326672L;
	
	public boolean registerUser(User user)
	{
		UserService userService = getProxyUserService();
		user.setCreateTime(new Date());
		user.setLastModifiedTime(new Date());
		
		return userService.registerUser(user);
	}
	
	public boolean modifyUser(User user)
	{
		UserService userService = getProxyUserService();
		user.setLastModifiedTime(new Date());
		return userService.modifyUser(user);
		
	}

	public boolean cancelUser(User user)
	{
		UserService userService = getProxyUserService();
		user = findUser(user);
		
		return userService.cancelUser(user);
	}

	public User findUser(User user)
	{
		UserService userService = getProxyUserService();
		return userService.findUser(user);
		
	}

	public User loginUsers(User user)
	{
		UserService userService = getProxyUserService();
		return userService.loginUser(user);
		
	}

	public List<User> listUser()
	{
		UserService userService = getProxyUserService();
		return userService.listUser();
	}
	
	private UserService getProxyUserService()
	{
		UserService userManager = new UserManager(entityManager);
		UserService userServiceProxy = (UserService) (jpaTransactionalProxyManager).proxyFor(userManager);
		return userServiceProxy;
	}

}
