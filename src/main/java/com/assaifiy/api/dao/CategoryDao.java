package com.assaifiy.api.dao;

import java.util.List;

import com.assaifiy.api.model.Category;
import com.assaifiy.api.model.SubCategory;

public interface CategoryDao {
		public boolean save(Category category);
		public boolean update(Category category);
		public boolean delete(Category category);
		public List<Category> getAllData();
		public Category findByCode(String categoryCode);
		public List<SubCategory> listSubCategory(String categoryCode);
}
