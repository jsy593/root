package com.fenghui.framework.services;

import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpaentities.RoomPassWord;

public interface RoomPassWordService
{
	@Transactional
	public boolean addRoomPassWord(RoomPassWord roomPassWord);
	
	@Transactional
	public boolean cancelRoomPassWord(RoomPassWord roomPassWord);
	
	@Transactional
	public boolean modifyRoomPassWord(RoomPassWord roomPassWord);
	
	public RoomPassWord findRoomPassWord(RoomPassWord roomPassWord);
	
	public List<RoomPassWord> listRoomPassWord();
}
