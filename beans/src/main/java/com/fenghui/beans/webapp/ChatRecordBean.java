package com.fenghui.beans.webapp;

import java.io.Serializable;
import java.util.List;

import com.fenghui.bases.jpaentities.ChatRecord;
import com.fenghui.beans.templates.BeanBase;
import com.fenghui.framework.services.ChatRecordService;
import com.fenghui.services.managers.ChatRecordManager;

public class ChatRecordBean  extends BeanBase implements Serializable
{
	private static final long serialVersionUID = 2748264995102238925L;

	public boolean addChatRecord(ChatRecord chatRecord)
	{
		ChatRecordService chatRecordService = getProxyChatRecordService();
		chatRecordService.addChatRecord(chatRecord);
		return true;
	}
	
	public boolean cancelChatRecord(ChatRecord chatRecord)
	{
		ChatRecordService chatRecordService = getProxyChatRecordService();
		chatRecord =findChatRecord(chatRecord);
		return chatRecordService.cancelChatRecord(chatRecord);
	}
	
	public ChatRecord findChatRecord(ChatRecord chatRecord)
	{
		ChatRecordService chatRecordService = getProxyChatRecordService();
		return chatRecordService.findChatRecord(chatRecord);
	}

	public List<ChatRecord> listChatRecord()
	{
		ChatRecordService chatRecordService = getProxyChatRecordService();
		return chatRecordService.listChatRecord();
	}
	
	
	private ChatRecordService getProxyChatRecordService()
	{
		ChatRecordService ChatRecordManager = new ChatRecordManager(entityManager);
		ChatRecordService ChatRecordServiceProxy = (ChatRecordService) (jpaTransactionalProxyManager).proxyFor(ChatRecordManager);
		return ChatRecordServiceProxy;
	}
	
}
