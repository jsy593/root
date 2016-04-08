package com.fenghui.bases.jpadtos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fenghui.bases.jpaentities.ChatRecord;

@Entity
@Table(name="PUBLISHED_CHAT_RECORDS")
public class PublishedChatRecordDTO implements Serializable
{

	private static final long serialVersionUID = 1677612565808371517L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@OneToOne(cascade ={ CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "CHAT_RECORD")
	private ChatRecord chatRecord;

	@Column(name = "PUBLISHED_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date publishedTIme;

	public PublishedChatRecordDTO()
	{
	}

	public PublishedChatRecordDTO(int id, ChatRecord chatRecord, Date publishedTIme)
	{
		this.id = id;
		this.chatRecord = chatRecord;
		this.publishedTIme = publishedTIme;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public ChatRecord getChatRecord()
	{
		return chatRecord;
	}

	public void setChatRecord(ChatRecord chatRecord)
	{
		this.chatRecord = chatRecord;
	}

	public Date getPublishedTIme()
	{
		return publishedTIme;
	}

	public void setPublishedTIme(Date publishedTIme)
	{
		this.publishedTIme = publishedTIme;
	}

}
