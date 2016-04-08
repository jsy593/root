package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.List;

import com.fenghui.bases.jpaentities.LeaveWord;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.LeaveWordService;
import com.fenghui.services.managers.LeaveWordManager;

public class LeaveWordsBean extends BeanBase implements Serializable
{

	private static final long serialVersionUID = 8892009069117605883L;

	public boolean addLeaveword(LeaveWord leaveword){
		LeaveWordService leaveWordService = getProxyLeaveWordService();
		return leaveWordService.addLeaveword(leaveword);
		
	}
	
	public boolean removeLeaveword(LeaveWord leaveword){
		LeaveWordService leaveWordService = getProxyLeaveWordService();
		return leaveWordService.removeLeaveword(leaveword);
	}
	
	public boolean modifyLeaveword(LeaveWord leaveword){
		LeaveWordService leaveWordService = getProxyLeaveWordService();
		return leaveWordService.modifyLeaveword(leaveword);
	}
	
	public LeaveWord findLeaveword(LeaveWord leaveword){
		LeaveWordService leaveWordService = getProxyLeaveWordService();
		return leaveWordService.findLeaveword(leaveword);
	}
	
	public List<LeaveWord> listLeaveword(){
		LeaveWordService leaveWordService = getProxyLeaveWordService();
		return leaveWordService.listLeaveword();
	}
	
	private LeaveWordService getProxyLeaveWordService()
	{
		LeaveWordService leaveWordManager = new LeaveWordManager(entityManager);
		LeaveWordService leaveWordServiceProxy = (LeaveWordManager) (jpaTransactionalProxyManager).proxyFor(leaveWordManager);
		return leaveWordServiceProxy;
	}
}
