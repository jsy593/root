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

import com.fenghui.bases.jpaentities.Product;
import com.fenghui.bases.jpaentities.Teacher;

@Entity
@Table(name = "TEACHERS_PRODUCTS")
public class TeacherProductDTO implements Serializable
{

	private static final long serialVersionUID = -7305261465002479392L;

	public TeacherProductDTO()
	{
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	
	@OneToOne(cascade =
	{ CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "TEACHER")
	private Teacher teacher;

	@OneToOne(cascade =
	{ CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "PRODUCT")
	private Product product;

	@Column(name = "CREATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	@Column(name = "LAST_MODIFIED_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedTime;

	@Column(name = "IS_DELETED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date isDeleted;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Teacher getTeacher()
	{
		return teacher;
	}

	public void setTeacher(Teacher teacher)
	{
		this.teacher = teacher;
	}

	public Product getProduct()
	{
		return product;
	}

	public void setProduct(Product product)
	{
		this.product = product;
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

	public Date getIsDeleted()
	{
		return isDeleted;
	}

	public void setIsDeleted(Date isDeleted)
	{
		this.isDeleted = isDeleted;
	}

}
