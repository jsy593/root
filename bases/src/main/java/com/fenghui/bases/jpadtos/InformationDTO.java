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

@Entity
@Table(name = "INFORMATIONS")
public class InformationDTO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1874897378417610330L;

	public InformationDTO()
	{
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "STOCK_CODE")
	private String stockCode;
	
	@Column(name = "STOCK_NAME")
	private String stockName;

	@Column(name = "RELEASE_TIME")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date releaseTime;
	
	@Column(name = "HOLDING_STATUS")
	private String holdingStatus;
	
	@Column(name = "HOLDING_PERCENT")
	private int holdingPercent;
	
	@Column(name = "PRICE_LOWEST")
	private float priceLowest;
	
	@Column(name = "PRICE_HIGHEST")
	private float priceHighest;
	
	@Column(name = "RECOMMENDATION")
	private String recommendation;
	
	@OneToOne(cascade =
	{ CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "OWNER")
	private TeacherDTO teachersDTO;
	
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

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getStockCode()
	{
		return stockCode;
	}

	public void setStockCode(String stockCode)
	{
		this.stockCode = stockCode;
	}

	public String getStockName()
	{
		return stockName;
	}

	public void setStockName(String stockName)
	{
		this.stockName = stockName;
	}

	public Date getReleaseTime()
	{
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime)
	{
		this.releaseTime = releaseTime;
	}

	public String getHoldingStatus()
	{
		return holdingStatus;
	}

	public void setHoldingStatus(String holdingStatus)
	{
		this.holdingStatus = holdingStatus;
	}

	public int getHoldingPercent()
	{
		return holdingPercent;
	}

	public void setHoldingPercent(int holdingPercent)
	{
		this.holdingPercent = holdingPercent;
	}

	public float getPriceLowest()
	{
		return priceLowest;
	}

	public void setPriceLowest(float priceLowest)
	{
		this.priceLowest = priceLowest;
	}

	public float getPriceHighest()
	{
		return priceHighest;
	}

	public void setPriceHighest(float priceHighest)
	{
		this.priceHighest = priceHighest;
	}

	public String getRecommendation()
	{
		return recommendation;
	}

	public void setRecommendation(String recommendation)
	{
		this.recommendation = recommendation;
	}

	public TeacherDTO getTeachersDTO()
	{
		return teachersDTO;
	}

	public void setTeachersDTO(TeacherDTO teachersDTO)
	{
		this.teachersDTO = teachersDTO;
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
