package com.assaifiy.api.dao;

import java.util.List;

import com.assaifiy.api.model.Picture;

public interface PictureDao {
	public boolean save(Picture picture);
	public boolean update(Picture picture);
	public List<Picture> getAllData(String bikeId);
}
