package com.fenghui.framework.services;

import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpaentities.User;

public interface UserService
{
	@Transactional
	public boolean registerUser(User user);

	@Transactional
	public boolean modifyUser(User user);

	@Transactional
	public boolean cancelUser(User user);

	public User findUser(User user);

	public User loginUser(User user);

	public List<User> listUser();
}
