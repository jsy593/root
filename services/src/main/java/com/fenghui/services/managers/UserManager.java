package com.fenghui.services.managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadaos.UserDAO;
import com.fenghui.bases.jpaentities.User;
import com.fenghui.commons.interfaces.IHandleEntity;
import com.fenghui.framework.services.UserService;

public class UserManager implements UserService
{
	protected IHandleEntity<User> handleUser;

	EntityManager entityManager;
	
	private final String JPQL_FIND_USER = "select e from Users e where e.ID=:userId";
	private final String JPQL_LOGIN_USER = "select e from Users e where e.userName=:userName and e.userPassword=:userPassword";// and e.userPerson=:person";
	private final String JPQL_LIST_USER = "select e from Users e";

	public UserManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public boolean registerUser(User user)
	{
		handleUser = new UserDAO(entityManager);
		handleUser.addEntity(user);
		handleUser.close();
		return true;
	}

	@Override
	@Transactional
	public boolean modifyUser(User user)
	{
		handleUser = new UserDAO(entityManager);
		handleUser.modifyEntity(user);
		handleUser.close();
		return true;
	}

	@Override
	@Transactional
	public boolean cancelUser(User user)
	{
		handleUser = new UserDAO(entityManager);
		handleUser.deleteEntity(user);
		handleUser.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findUser(User user)
	{
		Query query = entityManager.createQuery(JPQL_FIND_USER);
		query.setParameter("userId", user.getUserId());
		List<User> listuser = query.getResultList();

		if (listuser.size() == 0)
		{
			return null;
		}
		else
		{
			return listuser.get(0);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public User loginUser(User user)
	{
		System.out.println("****************"+user);
		Query query = entityManager.createQuery(JPQL_LOGIN_USER);
		
		query.setParameter("userName", user.getUserName());
		query.setParameter("userPassword", user.getUserPassword());
		System.out.println("yuju :"+JPQL_LOGIN_USER);
//		query.setParameter("person", users.getUserPerson());
		List<User> listuser = query.getResultList();
		System.out.println(listuser.size());
		if (listuser.size() == 0)
		{
			return null;
		}
		else
		{
			return listuser.get(0);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUser()
	{
		Query query = entityManager.createQuery(JPQL_LIST_USER);
		List<User> listuser = query.getResultList();

		return listuser;
	}

	
}
