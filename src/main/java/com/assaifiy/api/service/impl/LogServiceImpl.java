package com.assaifiy.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assaifiy.api.dao.LogActivityDao;
import com.assaifiy.api.model.LogActivity;
import com.assaifiy.api.service.LogActivityService;

@Service("logActivityService")
public class LogServiceImpl implements LogActivityService {
	
	@Autowired
	private LogActivityDao logActivityDao;

	@Override
	public void save(LogActivity logActivity) {
		logActivityDao.save(logActivity);
	}

	@Override
	public List<LogActivity> getLog() {
		return logActivityDao.getLog();
	}

}
