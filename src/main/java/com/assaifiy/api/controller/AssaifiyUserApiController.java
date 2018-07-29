package com.assaifiy.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assaifiy.api.model.Response;
import com.assaifiy.api.service.AssaifiyService;

@RestController
public class AssaifiyUserApiController {

	@Autowired
	private AssaifiyService assaifiyService;

	@RequestMapping(value="assaifiy/v1/categories", method = RequestMethod.GET)
	public ResponseEntity<Response> categories(){
		Response categoryResponse = new Response();
			categoryResponse.setCode(""+HttpStatus.PROCESSING);
			categoryResponse.setStatus("Processing Request");
			categoryResponse.setMessage("Request Processed");
			categoryResponse.setObj(assaifiyService.listCategory());
			return new ResponseEntity<Response>(categoryResponse, HttpStatus.OK);
	}
	@RequestMapping(value="assaifiy/v1/subcategories", method = RequestMethod.GET)
	public ResponseEntity<Response> SubCategories(){
		Response categoryResponse = new Response();
		categoryResponse.setCode(""+HttpStatus.PROCESSING);
		categoryResponse.setStatus("Processing Request");
		categoryResponse.setMessage("Request Processed");
		categoryResponse.setObj(assaifiyService.listSubCategory());
		return new ResponseEntity<Response>(categoryResponse, HttpStatus.OK);
	}
	@RequestMapping(value="assaifiy/v1/bikes", method = RequestMethod.GET)
	public ResponseEntity<Response> bikes(){
		Response response = new Response();
		response.setCode(""+HttpStatus.PROCESSING);
		response.setStatus("Processing Request");
		response.setMessage("Request Processed");
		response.setObj(assaifiyService.listBike());
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	@RequestMapping(value="assaifiy/v1/bike-details", method = RequestMethod.POST)
	public ResponseEntity<Response> bikeDetails(@RequestBody int bikeCode){
		Response response = new Response();
		response.setCode(""+HttpStatus.PROCESSING);
		response.setStatus("Processing Request");
		response.setMessage("Request Processed");
		response.setObj(assaifiyService.findBikeByCode(bikeCode));
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
}
