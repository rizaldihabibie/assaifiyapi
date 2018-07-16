package com.assaifiy.api.dao;

import java.util.List;

import com.assaifiy.api.model.Bike;

public interface BikeDao {
	public boolean save(Bike bike);
	public boolean update(Bike bike);
	public List<Bike> getAllData();
	public List<Bike> findBySubCategory(String subCategoryCode);
	public List<Bike> findByCategory(String categoryCode);
	public Bike findByCode(String bikeCode);

}
