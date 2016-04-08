package com.fenghui.bases.jpaentities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PUBLISHED_CHAT_RECORDS")
public class PublishedChatRecord implements Serializable
{
	private static final long serialVersionUID = 2074608848155966522L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "CHAT_RECORD")
	private int chatRecordId;

	@Column(name = "PUBLISHED_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date publishedTIme;

	public PublishedChatRecord(int id, int chatRecordId, Date publishedTIme)
	{
		super();
		this.id = id;
		this.chatRecordId = chatRecordId;
		this.publishedTIme = publishedTIme;
	}
	
	public PublishedChatRecord()
	{
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getChatRecordId()
	{
		return chatRecordId;
	}

	public void setChatRecordId(int chatRecordId)
	{
		this.chatRecordId = chatRecordId;
	}

	public Date getPublishedTIme()
	{
		return publishedTIme;
	}

	public void setPublishedTIme(Date publishedTIme)
	{
		this.publishedTIme = publishedTIme;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

}
