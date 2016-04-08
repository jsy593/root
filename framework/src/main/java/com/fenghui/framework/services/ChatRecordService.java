package com.fenghui.framework.services;

import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpaentities.ChatRecord;

public interface ChatRecordService
{
	@Transactional
	public boolean addChatRecord(ChatRecord chatRecord);
	
	@Transactional
	public boolean cancelChatRecord(ChatRecord chatRecord);
	
	@Transactional
	public boolean modifyChatRecord(ChatRecord chatRecord);
	
	public ChatRecord findChatRecord(ChatRecord chatRecord);
	
	public List<ChatRecord> listChatRecord();
}
