package com.assaifiy.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="sub_category")
public class SubCategory {

	@Id
	@Column(name="subcategory_id")
	private int id;
	
	@Column(name="subcategory_code")
	private String subCategoryCode;
	
	@Column(name="subcategory_name")
	private String subCategoryName;
	
	@Column(name="status")
	private String status;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Category category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubCategoryCode() {
		return subCategoryCode;
	}

	public void setSubCategoryCode(String subCategoryCode) {
		this.subCategoryCode = subCategoryCode;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
