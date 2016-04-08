package com.fenghui.bases.jpadtos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fenghui.bases.jpaentities.News;

@Entity
@Table(name="NEWS_TYPE")
public class NewsTypeDTO implements Serializable
{
	
	private static final long serialVersionUID = -7273307336981779271L;

		@Id
		@Column(name = "ID",length=10)
		@GeneratedValue
		private int id;
		
		@ManyToOne(cascade ={ CascadeType.MERGE, CascadeType.REFRESH })
	    @JoinColumn(name = "NEWS")
		private News news;
		
		@Column(name = "TYPE")
		private String type;

		@Column(name = "CREATE_TIME", nullable=true)
		@Temporal(TemporalType.TIMESTAMP) 
		private Date createTime;

		@Column(name = "LAST_MODIFIED_TIME", nullable=true)
		@Temporal(TemporalType.TIMESTAMP) 
		private Date lastModifiedTime;
		
		@Column(name = "IS_DELETED")
		private Boolean isDeleted;

		public NewsTypeDTO()
		{
		}

		public NewsTypeDTO(int id, String type, Date createTime, Date lastModifiedTime, Boolean isDeleted)
		{
			this.id = id;
			this.type = type;
			this.createTime = createTime;
			this.lastModifiedTime = lastModifiedTime;
			this.isDeleted = isDeleted;
		}

		public int getId()
		{
			return id;
		}

		public void setId(int id)
		{
			this.id = id;
		}

		public News getNews()
		{
			return news;
		}

		public void setNews(News news)
		{
			this.news = news;
		}

		public String getType()
		{
			return type;
		}

		public void setType(String type)
		{
			this.type = type;
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

		public Boolean getIsDeleted()
		{
			return isDeleted;
		}

		public void setIsDeleted(Boolean isDeleted)
		{
			this.isDeleted = isDeleted;
		}

		public static long getSerialversionuid()
		{
			return serialVersionUID;
		}

}
