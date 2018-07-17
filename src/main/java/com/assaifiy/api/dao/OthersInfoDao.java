package com.assaifiy.api.dao;

import java.util.List;

import com.assaifiy.api.model.OthersInfo;

public interface OthersInfoDao {
	public boolean save(OthersInfo othersInfo);
	public boolean update(OthersInfo othersInfo);
	public List<OthersInfo> getAllData(String bikeId);
	
}
