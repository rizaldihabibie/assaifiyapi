package com.assaifiy.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assaifiy.api.dao.BikeDao;
import com.assaifiy.api.dao.CategoryDao;
import com.assaifiy.api.dao.OthersInfoDao;
import com.assaifiy.api.dao.PictureDao;
import com.assaifiy.api.dao.SubCategoryDao;
import com.assaifiy.api.model.Bike;
import com.assaifiy.api.model.Category;
import com.assaifiy.api.model.OthersInfo;
import com.assaifiy.api.model.Picture;
import com.assaifiy.api.model.SubCategory;
import com.assaifiy.api.service.AssaifiyService;

@Service("assaifiyService")
public class AssaifiServiceImpl implements AssaifiyService{

	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private SubCategoryDao subCategoryDao;
	@Autowired
	private BikeDao bikeDao;
	@Autowired
	private OthersInfoDao othersInfoDao;
	@Autowired
	private PictureDao pictureDao;
	
	@Override
	public boolean save(Bike bike) {
		return bikeDao.save(bike);
	}

	@Override
	public boolean update(Bike bike) {
		return bikeDao.update(bike);
	}

	@Override
	public List<Bike> listBike() {
		return bikeDao.getAllData();
	}

	@Override
	public List<Bike> findBySubCategory(String subCategoryCode) {
		return bikeDao.findBySubCategory(subCategoryCode);
	}

	@Override
	public List<Bike> findByCategory(String categoryCode) {
		return bikeDao.findByCategory(categoryCode);
	}

	@Override
	public Bike findBikeByCode(String bikeCode) {
		return bikeDao.findByCode(bikeCode);
	}

	@Override
	public boolean save(Category category) {
		return categoryDao.save(category);
	}

	@Override
	public boolean update(Category category) {
		return categoryDao.update(category);
	}

	@Override
	public List<Category> listCategory() {
		return categoryDao.getAllData();
	}

	@Override
	public Category findCategoryByCode(String categoryCode) {
		return categoryDao.findByCode(categoryCode);
	}

	@Override
	public List<SubCategory> listSubCategory(String categoryCode) {
		return categoryDao.listSubCategory(categoryCode);
	}

	@Override
	public boolean save(OthersInfo othersInfo) {
		return othersInfoDao.save(othersInfo);
	}

	@Override
	public boolean update(OthersInfo othersInfo) {
		return othersInfoDao.update(othersInfo);
	}

	@Override
	public List<OthersInfo> listOthersInfo(String bikeId) {
		return othersInfoDao.getAllData(bikeId);
	}

	@Override
	public boolean save(Picture picture) {
		return pictureDao.save(picture);
	}

	@Override
	public boolean update(Picture picture) {
		return pictureDao.update(picture);
	}

	@Override
	public List<Picture> listPicture(String bikeId) {
		return pictureDao.getAllData(bikeId);
	}

	@Override
	public boolean save(SubCategory subCategory) {
		// TODO Auto-generated method stub
		return subCategoryDao.save(subCategory);
	}

	@Override
	public boolean update(SubCategory subCategory) {
		// TODO Auto-generated method stub
		return subCategoryDao.save(subCategory);
	}

	@Override
	public SubCategory findSubCategoryByCode(String subCategoryCode) {
		// TODO Auto-generated method stub
		return subCategoryDao.findByCode(subCategoryCode);
	}

	@Override
	public List<SubCategory> listSubCategory() {
		// TODO Auto-generated method stub
		return subCategoryDao.getAllData();
	}

}
