package com.assaifiy.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value="v1/categories/{categoryCode}", method = RequestMethod.GET)
	public ResponseEntity<Response> categories(@PathVariable("categoryCode") String category){
		
		Response categoryResponse = new Response();
		categoryResponse.setCode(""+HttpStatus.PROCESSING);
		categoryResponse.setStatus("Processing Request");
		categoryResponse.setMessage("Request Processed");
		if(category.equals("all") && category != null){
			categoryResponse.setObj(assaifiyService.listCategory());
		}else{
			categoryResponse.setObj(assaifiyService.findByCategory(category));
		}
		return new ResponseEntity<Response>(categoryResponse, HttpStatus.OK);
	}
	@RequestMapping(value="v1/subcategories", method = RequestMethod.GET)
	public ResponseEntity<Response> SubCategories(){
		Response categoryResponse = new Response();
		categoryResponse.setCode(""+HttpStatus.PROCESSING);
		categoryResponse.setStatus("Processing Request");
		categoryResponse.setMessage("Request Processed");
		categoryResponse.setObj(assaifiyService.listSubCategory());
		return new ResponseEntity<Response>(categoryResponse, HttpStatus.OK);
	}
	@RequestMapping(value="v1/bikes/{categoryCode}", method = RequestMethod.GET)
	public ResponseEntity<Response> bikes(@PathVariable("categoryCode") String categoryCode){
		Response response = new Response();
		response.setCode(""+HttpStatus.PROCESSING);
		response.setStatus("Processing Request");
		response.setMessage("Request Processed");
		if(categoryCode.equals("all") && categoryCode != null){
			response.setObj(assaifiyService.listBike());
		}else{
			response.setObj(assaifiyService.findBySubCategory(categoryCode));
		}
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	@RequestMapping(value="v1/bike-details", method = RequestMethod.POST)
	public ResponseEntity<Response> bikeDetails(@RequestBody int bikeCode){
		Response response = new Response();
		response.setCode(""+HttpStatus.PROCESSING);
		response.setStatus("Processing Request");
		response.setMessage("Request Processed");
		response.setObj(assaifiyService.findBikeByCode(bikeCode));
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
}
