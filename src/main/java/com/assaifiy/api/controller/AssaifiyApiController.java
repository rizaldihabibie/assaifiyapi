package com.assaifiy.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assaifiy.api.model.Bike;
import com.assaifiy.api.model.Category;
import com.assaifiy.api.model.OthersInfo;
import com.assaifiy.api.model.Response;
import com.assaifiy.api.model.SubCategory;
import com.assaifiy.api.service.AssaifiyService;

@RestController
public class AssaifiyApiController {
	
	@Autowired
	private AssaifiyService assaifiyService;

	@RequestMapping(value="${api.version}/categories", method = RequestMethod.POST)
	public ResponseEntity<Response> categories(){
		Response categoryResponse = new Response();
			categoryResponse.setCode(""+HttpStatus.PROCESSING);
			categoryResponse.setStatus("Processing Request");
			categoryResponse.setMessage("Request Processed");
			categoryResponse.setObj(assaifiyService.listCategory());
			return new ResponseEntity<Response>(categoryResponse, HttpStatus.OK);
	}
	@RequestMapping(value="${api.version}/add-category", method = RequestMethod.POST)
	public ResponseEntity<Response> addCategory(@RequestBody Category category){
		Response categoryResponse = new Response();
		if(assaifiyService.save(category)){
			categoryResponse.setCode(""+HttpStatus.CREATED);
			categoryResponse.setStatus("Success !");
			categoryResponse.setMessage("Request Processed");
			categoryResponse.setObj(null);
		}else{
			categoryResponse.setCode(""+HttpStatus.NOT_ACCEPTABLE);
			categoryResponse.setStatus("Failed !");
			categoryResponse.setMessage("Failed to save data");
			categoryResponse.setObj(null);
		}
		return new ResponseEntity<Response>(categoryResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value="${api.version}/update-category", method = RequestMethod.POST)
	public ResponseEntity<Response> updateCategory(@RequestBody Category category){
		Response categoryResponse = new Response();
		if(assaifiyService.update(category)){
			categoryResponse.setCode(""+HttpStatus.CREATED);
			categoryResponse.setStatus("Success !");
			categoryResponse.setMessage("Request Processed");
			categoryResponse.setObj(null);
		}else{
			categoryResponse.setCode(""+HttpStatus.NOT_ACCEPTABLE);
			categoryResponse.setStatus("Failed !");
			categoryResponse.setMessage("Failed to save data");
			categoryResponse.setObj(null);
		}
		return new ResponseEntity<Response>(categoryResponse, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="${api.version}/subcategories", method = RequestMethod.POST)
	public ResponseEntity<Response> SubCategories(){
		Response categoryResponse = new Response();
		categoryResponse.setCode(""+HttpStatus.PROCESSING);
		categoryResponse.setStatus("Processing Request");
		categoryResponse.setMessage("Request Processed");
		categoryResponse.setObj(assaifiyService.listSubCategory());
		return new ResponseEntity<Response>(categoryResponse, HttpStatus.OK);
	}
	@RequestMapping(value="${api.version}/add-sub-category", method = RequestMethod.POST)
	public ResponseEntity<Response> addSubCategory(@RequestBody SubCategory subCategory){
		Response categoryResponse = new Response();
		if(assaifiyService.save(subCategory)){
			categoryResponse.setCode(""+HttpStatus.CREATED);
			categoryResponse.setStatus("Success !");
			categoryResponse.setMessage("Request Processed");
			categoryResponse.setObj(null);
		}else{
			categoryResponse.setCode(""+HttpStatus.NOT_ACCEPTABLE);
			categoryResponse.setStatus("Failed !");
			categoryResponse.setMessage("Failed to save data");
			categoryResponse.setObj(null);
		}
		return new ResponseEntity<Response>(categoryResponse, HttpStatus.OK);
	}
	@RequestMapping(value="${api.version}/update-sub-category", method = RequestMethod.POST)
	public ResponseEntity<Response> updateSubCategory(@RequestBody SubCategory subCategory){
		Response categoryResponse = new Response();
		if(assaifiyService.update(subCategory)){
			categoryResponse.setCode(""+HttpStatus.CREATED);
			categoryResponse.setStatus("Success !");
			categoryResponse.setMessage("Request Processed");
			categoryResponse.setObj(null);
		}else{
			categoryResponse.setCode(""+HttpStatus.NOT_ACCEPTABLE);
			categoryResponse.setStatus("Failed !");
			categoryResponse.setMessage("Failed to save data");
			categoryResponse.setObj(null);
		}
		return new ResponseEntity<Response>(categoryResponse, HttpStatus.OK);
	}
	@RequestMapping(value="${api.version}/bikes", method = RequestMethod.POST)
	public ResponseEntity<Response> bikes(){
		Response response = new Response();
		response.setCode(""+HttpStatus.PROCESSING);
		response.setStatus("Processing Request");
		response.setMessage("Request Processed");
		response.setObj(assaifiyService.listBike());
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	@RequestMapping(value="${api.version}/bike-details", method = RequestMethod.POST)
	public ResponseEntity<Response> bikeDetails(@RequestBody int bikeCode){
		Response response = new Response();
		response.setCode(""+HttpStatus.PROCESSING);
		response.setStatus("Processing Request");
		response.setMessage("Request Processed");
		response.setObj(assaifiyService.findBikeByCode(bikeCode));
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	@RequestMapping(value="${api.version}/update-bike", method = RequestMethod.POST)
	public ResponseEntity<Response> updateBike(@RequestBody Bike bike){
		Response response = new Response();
		if(assaifiyService.update(bike)){
			response.setCode(""+HttpStatus.CREATED);
			response.setStatus("Success !");
			response.setMessage("Request Processed");
			response.setObj(null);
		}else{
			response.setCode(""+HttpStatus.NOT_ACCEPTABLE);
			response.setStatus("Failed !");
			response.setMessage("Failed to save data");
			response.setObj(null);
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	@RequestMapping(value="${api.version}/update-other-info", method = RequestMethod.POST)
	public ResponseEntity<Response> updateOtherInfo(@RequestBody OthersInfo otherInfo){
		Response response = new Response();
		if(assaifiyService.update(otherInfo)){
			response.setCode(""+HttpStatus.CREATED);
			response.setStatus("Success !");
			response.setMessage("Request Processed");
			response.setObj(null);
		}else{
			response.setCode(""+HttpStatus.NOT_ACCEPTABLE);
			response.setStatus("Failed !");
			response.setMessage("Failed to save data");
			response.setObj(null);
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	@RequestMapping(value="${api.version}/add-other-info", method = RequestMethod.POST)
	public ResponseEntity<Response> addOtherInfo(@RequestBody OthersInfo otherInfo){
		System.out.print(otherInfo.getBike().getId());
		Response response = new Response();
		if(assaifiyService.save(otherInfo)){
			response.setCode(""+HttpStatus.CREATED);
			response.setStatus("Success !");
			response.setMessage("Request Processed");
			response.setObj(null);
		}else{
			response.setCode(""+HttpStatus.NOT_ACCEPTABLE);
			response.setStatus("Failed !");
			response.setMessage("Failed to save data");
			response.setObj(null);
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}
