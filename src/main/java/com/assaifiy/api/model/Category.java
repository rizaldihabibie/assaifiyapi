package com.assaifiy.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="category")
public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2765288464615191170L;

	@Id
	@Column(name="category_id")
	private int id;
	
	@Column(name="category_code")
	private String categoryCode;
	
	@Column(name="category_name")
	private String categoryName;
	
	@Column(name="status")
	private String status;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="url")
	private String url;
	
	@OneToMany(mappedBy="category")
	@Where(clause="status = 'ACTIVE'")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","category"})
	private List<SubCategory> listSubCategory;
	
	public List<SubCategory> getListSubCategory() {
		return listSubCategory;
	}

	public void setListSubCategory(List<SubCategory> listSubCategory) {
		this.listSubCategory = listSubCategory;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
