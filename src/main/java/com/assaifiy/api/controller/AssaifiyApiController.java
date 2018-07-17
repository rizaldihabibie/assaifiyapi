package com.assaifiy.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assaifiy.api.model.CategoryResponse;
import com.assaifiy.api.service.AssaifiyService;

@RestController
public class AssaifiyApiController {
	
	@Autowired
	private AssaifiyService assaifiyService;

	@RequestMapping(value="${api.version}/categories", method = RequestMethod.POST)
	public @ResponseBody CategoryResponse Categories(@RequestHeader("authorization") String authString){
		CategoryResponse categoryResponse = new CategoryResponse();
		if(authString != null){
			categoryResponse.setCode(""+HttpStatus.PROCESSING);
			categoryResponse.setStatus("Processing Request");
			categoryResponse.setMessage("Request Processed");
			categoryResponse.setObj(assaifiyService.listCategory());
		}else{
			categoryResponse.setCode(""+HttpStatus.BAD_REQUEST);
			categoryResponse.setStatus("Bad Request");
			categoryResponse.setMessage("Empty Header");
		}
		return categoryResponse;
	}
}
