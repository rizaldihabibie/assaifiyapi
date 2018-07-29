package com.assaifiy.api.dao;

import java.util.List;

import com.assaifiy.api.model.LogActivity;

public interface LogActivityDao {
	public void save(LogActivity logActivity);
	public List<LogActivity> getLog();

}
