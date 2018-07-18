package com.assaifiy.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assaifiy.api.model.Response;
import com.assaifiy.api.service.AssaifiyService;

@RestController
public class AssaifiyApiController {
	
	@Autowired
	private AssaifiyService assaifiyService;

	@RequestMapping(value="${api.version}/categories", method = RequestMethod.POST)
	public @ResponseBody Response Categories(@RequestHeader("authorization") String authString){
		Response categoryResponse = new Response();
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
	
	@RequestMapping(value="${api.version}/subcategories", method = RequestMethod.POST)
	public @ResponseBody Response SubCategories(@RequestHeader("authorization") String authString){
		Response categoryResponse = new Response();
		if(authString != null){
			categoryResponse.setCode(""+HttpStatus.PROCESSING);
			categoryResponse.setStatus("Processing Request");
			categoryResponse.setMessage("Request Processed");
			categoryResponse.setObj(assaifiyService.listSubCategory());
		}else{
			categoryResponse.setCode(""+HttpStatus.BAD_REQUEST);
			categoryResponse.setStatus("Bad Request");
			categoryResponse.setMessage("Empty Header");
		}
		return categoryResponse;
	}
	@RequestMapping(value="${api.version}/bikes", method = RequestMethod.POST)
	public @ResponseBody Response bikes(@RequestHeader("authorization") String authString){
		Response response = new Response();
		if(authString != null){
			response.setCode(""+HttpStatus.PROCESSING);
			response.setStatus("Processing Request");
			response.setMessage("Request Processed");
			response.setObj(assaifiyService.listBike());
		}else{
			response.setCode(""+HttpStatus.BAD_REQUEST);
			response.setStatus("Bad Request");
			response.setMessage("Empty Header");
		}
		return response;
	}
}
