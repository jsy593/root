package com.fenghui.framework.services;

import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpaentities.LeaveWord;

public interface LeaveWordService
{
	@Transactional
	public boolean addLeaveword(LeaveWord leaveword);
	
	@Transactional
	public boolean removeLeaveword(LeaveWord leaveword);
	
	@Transactional
	public boolean modifyLeaveword(LeaveWord leaveword);
	
	public LeaveWord findLeaveword(LeaveWord leaveword);
	
	public List<LeaveWord> listLeaveword();
}
