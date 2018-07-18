package com.assaifiy.api.dao;

import java.util.List;

import com.assaifiy.api.model.SubCategory;

public interface SubCategoryDao {
	public boolean save(SubCategory subCategory);
	public boolean update(SubCategory subCategory);
	public boolean delete(SubCategory subCategory);
	public SubCategory findByCode(String subCategoryCode);
	public List<SubCategory> getAllData();
}
