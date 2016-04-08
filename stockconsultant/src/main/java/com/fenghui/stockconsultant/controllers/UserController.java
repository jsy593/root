package com.fenghui.stockconsultant.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.fenghui.bases.handlejpa.ControllerBase;
import com.fenghui.bases.jpaentities.User;
import com.fenghui.beans.webapp.UserBean;

@ManagedBean(name = "userController")
@SessionScoped
public class UserController extends ControllerBase implements Serializable
{

	private static final long serialVersionUID = -1729328757361469929L;
	UserBean usersBean = new UserBean();
	private User users = new User();
	private User updatingUser = new User();
	private List<User> listUser = usersBean.listUser();

	
	public String registerUsers(User users)
	{/*userBean.registerUser(user);
			user = new User();
			users = userBean.listUsers();
			return "/users/ajaxAddUser.xhtml";*/
		
		return "";
	}
	
	public String modifyUsers(User users)
	{
		return "";
		
	}

	public String cancelUsers(User users)
	{
		return "";
	}

	public String findUsers(User users)
	{
		return "";
	}

	public String loginUsers()
	{
//		users.setUserPerson(product);
//		userBean.registerUser(user);
//		user = new User();
//		users = userBean.listUsers();
//		return "/users/ajaxAddUser.xhtml";
		
		System.out.println("******************************"+users.getUserName()+"	"+users.getUserPassword());//+"		"+users.getUserPerson());
		
		
		System.out.println(usersBean.loginUsers(users).getUserId());
		return "demo.xhtml";
		
	}

	public String listUsers()
	{
		return "";
	}

	public UserBean getUsersBean()
	{
		return usersBean;
	}

	public void setUsersBean(UserBean usersBean)
	{
		this.usersBean = usersBean;
	}

	public User getUsers()
	{
		return users;
	}

	public void setUsers(User users)
	{
		this.users = users;
	}

	public User getUpdatingUser()
	{
		return updatingUser;
	}

	public void setUpdatingUser(User updatingUser)
	{
		this.updatingUser = updatingUser;
	}

	public List<User> getListUser()
	{
		return listUser;
	}

	public void setListUser(List<User> listUser)
	{
		this.listUser = listUser;
	}

	
}
