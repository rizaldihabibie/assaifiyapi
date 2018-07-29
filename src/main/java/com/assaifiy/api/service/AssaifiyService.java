package com.assaifiy.api.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.assaifiy.api.model.Bike;
import com.assaifiy.api.model.Category;
import com.assaifiy.api.model.OthersInfo;
import com.assaifiy.api.model.Picture;
import com.assaifiy.api.model.SubCategory;

public interface AssaifiyService {
	public boolean save(Bike bike);
	public boolean update(Bike bike);
	public List<Bike> listBike();
	public List<Bike> findBySubCategory(String subCategoryCode);
	public List<Bike> findByCategory(String categoryCode);
	public Bike findBikeByCode(int bikeCode);
	
	/**
	 * Category Service
	 */
	public boolean save(Category category);
	public boolean update(Category category);
	
	@Secured ("ROLE_ADMIN")
	public List<Category> listCategory();
	
	public Category findCategoryByCode(String categoryCode);
	public List<SubCategory> listSubCategory(String categoryCode);
	
	/**
	 * Others Info Service
	 */
	public boolean save(OthersInfo othersInfo);
	public boolean update(OthersInfo othersInfo);
	public List<OthersInfo> listOthersInfo(String bikeId);
	
	/**
	 * Picture Service
	 */
	public boolean save(Picture picture);
	public boolean update(Picture picture);
	public List<Picture> listPicture(String bikeId);
	
	/**Sub Category Service
	 * 
	 */
	public boolean save(SubCategory subCategory);
	public boolean update(SubCategory subCategory);
	public SubCategory findSubCategoryByCode(String subCategoryCode);
	public List<SubCategory> listSubCategory();
	
}
