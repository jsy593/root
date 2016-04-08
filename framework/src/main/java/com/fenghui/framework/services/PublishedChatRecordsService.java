package com.fenghui.framework.services;

import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpaentities.PublishedChatRecord;
public interface PublishedChatRecordsService
{
	@Transactional
	public boolean addPublishedChatRecords(PublishedChatRecord publishedChatRecords);
	
	@Transactional
	public boolean cancelPublishedChatRecords(PublishedChatRecord publishedChatRecords);
	
	@Transactional
	public boolean modifyPublishedChatRecords(PublishedChatRecord publishedChatRecords);
	
	public PublishedChatRecord  findPublishedChatRecords(PublishedChatRecord publishedChatRecords);
	
	public List<PublishedChatRecord> listPublishedChatRecords();
}
