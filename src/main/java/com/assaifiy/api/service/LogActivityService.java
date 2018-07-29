package com.assaifiy.api.service;

import java.util.List;

import com.assaifiy.api.model.LogActivity;

public interface LogActivityService {
	public void save(LogActivity logActivity);
	public List<LogActivity> getLog();
}
