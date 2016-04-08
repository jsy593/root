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
@Table(name = "LEAVE_WORDS")
public class LeaveWord implements Serializable
{
	private static final long serialVersionUID = 6220021407112591476L;

	public LeaveWord()
	{
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "CONTENT")
	private String content;

	@Column(name = "WORD_LEAVER")
	private String wordLeaver;

	@Column(name = "MOBILE_PHONE")
	private String mobilePhone;
	
	@Column(name = "IP_ADDRESS")
	private String ipAddress;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "CREATE_TIME")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date createTime;

	@Column(name = "LAST_MODIFIED_TIME")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date lastModifiedTime;

	@Column(name = "IS_DELETED")
	private boolean isDelete;
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getWordLeaver()
	{
		return wordLeaver;
	}

	public void setWordLeaver(String wordLeaver)
	{
		this.wordLeaver = wordLeaver;
	}

	public String getMobilePhone()
	{
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone)
	{
		this.mobilePhone = mobilePhone;
	}

	public String getIpAddress()
	{
		return ipAddress;
	}

	public void setIpAddress(String ipAddress)
	{
		this.ipAddress = ipAddress;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public Date getLastModifiedTime()
	{
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime)
	{
		this.lastModifiedTime = lastModifiedTime;
	}

	public boolean isDelete()
	{
		return isDelete;
	}

	public void setDelete(boolean isDelete)
	{
		this.isDelete = isDelete;
	}


	

}
