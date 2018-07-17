package com.assaifiy.api;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.assaifiy.api.dao.BikeDao;
import com.assaifiy.api.dao.CategoryDao;
import com.assaifiy.api.dao.OthersInfoDao;
import com.assaifiy.api.dao.PictureDao;
import com.assaifiy.api.dao.SubCategoryDao;
import com.assaifiy.api.model.Bike;
import com.assaifiy.api.model.Category;
import com.assaifiy.api.model.OthersInfo;
import com.assaifiy.api.model.Picture;
import com.assaifiy.api.model.SubCategory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssaifiyApplicationTests {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private SubCategoryDao subCategoryDao;
	
	@Autowired
	private BikeDao bikeDao;
	
	@Autowired
	private OthersInfoDao othersInfoDao;
	
	@Autowired
	private PictureDao pictureDao;
	
	private Category category;
	private SubCategory subCategory;
	private Bike bike;
	private OthersInfo othersInfo;
	private Picture pic;
	
	@Test
	public void testSaveCategory() {
		category = new Category();
		category.setCategoryName("MATIC");
		category.setCategoryCode("MATIC001");
		category.setStatus("ON");
		category.setCreatedBy("admoo1");
		category.setCreatedDate(new Date());
		boolean result = categoryDao.save(category);
		assertEquals(result,true);
	}
	
	@Test
	public void testCategoriFindByCode() {
		assertEquals(categoryDao.findByCode("CAT001").getCategoryName(),"BEBEK");
	}
	
	@Test
	public void testFindSubCategory() {
		assertEquals(categoryDao.listSubCategory("1").size(),3);
	}
	
	@Test
	public void testGetAllDataCategory() {
		assertEquals(categoryDao.getAllData().size(),2);
	}
	
	@Test
	public void testUpdateCategory() {
		category = categoryDao.findByCode("CAT001");
		category.setCategoryName("BEBEK");
		assertEquals(categoryDao.update(category),true);
	}
	

	
	@Test
	public void testDeleteCategory(){
		category = categoryDao.findByCode("MATIC001");
		assertEquals(categoryDao.delete(category),true);
	}

	@Test
	public void testSaveSubCategory() {
		category = categoryDao.findByCode("CAT001");
		subCategory = new SubCategory();
		subCategory.setSubCategoryName("VARIO 125");
		subCategory.setSubCategoryCode("VRI125");
		subCategory.setStatus("ON");
		subCategory.setCreatedBy("admoo1");
		subCategory.setCreatedDate(new Date());
		subCategory.setCategory(category);
		boolean result = subCategoryDao.save(subCategory);
		assertEquals(result,true);
	}
	
	@Test
	public void testSubCategoryFindByCode() {
		assertEquals(subCategoryDao.findByCode("BB238").getSubCategoryName(),"HONDA");
	}
	
	@Test
	public void testUpdateSubCategory() {
		subCategory = subCategoryDao.findByCode("HNDTGR");
		subCategory.setSubCategoryCode("YMHJOS");
		assertEquals(subCategoryDao.update(subCategory),true);
	}
	
	@Test
	public void testDeleteSubCategory() {
		subCategory = subCategoryDao.findByCode("VRI125");
		assertEquals(subCategoryDao.delete(subCategory),true);
	}
	
	@Test
	public void testSaveBike(){
		List<OthersInfo> listOthersInfo = new ArrayList<>();
		othersInfo = new OthersInfo();
		othersInfo.setInfoTitle("Velg");
		othersInfo.setInfo("Velg R18 racing");
		othersInfo.setStatus("ACTIVE");
		othersInfo.setCreatedDate(new Date());
		othersInfo.setCreatedBy("adm001");
		listOthersInfo.add(othersInfo);
		
		List<Picture> listPicture = new ArrayList<>();
		Picture pic = new Picture();
		pic.setCreatedBy("adm001");
		pic.setCreatedDate(new Date());
		pic.setPictureName("blobblobblob");
		pic.setStatus("GENERAL");
		listPicture.add(pic);
		subCategory = subCategoryDao.findByCode("HNDTGR");
		bike = new Bike();
		bike.setBikeCode("Honda001");
		bike.setAdTitle("Honda Vario 125 Hitam");
		bike.setBrand("Honda");
		bike.setType("CB 150");
		bike.setPlateNumber("H6785IO");
		bike.setYear("2013");
		bike.setColor("Black");
		bike.setTaxExpense(new Date());
		bike.setVehicleOwnership("T3");
		bike.setMileage("50000 Km");
		bike.setLettersCompleteness("STNK, BPKB, PAJAK");
		bike.setPayment("Cash");
		bike.setAdditionalInfo("Pernah jatuh");
		bike.setStatus("ACTIVE");
		bike.setCreatedDate(new Date());
		bike.setSubCategory(subCategory);
		bike.setCreatedBy("1");
		bike.setListOthersInfo(listOthersInfo);
		bike.setListPicture(listPicture);
		assertEquals(bikeDao.save(bike),true);
	}
	
	@Test
	public void testFindByCode(){
		bike = bikeDao.findByCode("hnd001");
		assertEquals(bike.getBrand(),"Huuonda");
	}
	
	@Test
	public void testUpdateBike(){
		bike = bikeDao.findByCode("hnd001");
		bike.setBrand("Huuonda");
		assertEquals(bikeDao.update(bike), true);
	}
	
	@Test
	public void testGetAllDataBike(){
		assertEquals(bikeDao.getAllData().size(), 5);
	}
	
	@Test
	public void testFindBySubCategory(){
		assertEquals(bikeDao.findBySubCategory("1").size(),3);
	}
	
	@Test
	public void testFindByCategory(){
		assertEquals(bikeDao.findByCategory("1").size(),5);
	}
	
	@Test
	public void testSaveOthersInfo(){
		bike = bikeDao.findByCode("hnd001");
		othersInfo = new OthersInfo();
		othersInfo.setInfoTitle("Body");
		othersInfo.setInfo("Full Sticker Protector");
		othersInfo.setStatus("ACTIVE");
		othersInfo.setCreatedDate(new Date());
		othersInfo.setCreatedBy("adm001");
		othersInfo.setBike(bike);
		assertEquals(othersInfoDao.save(othersInfo), true);
	}
	
	@Test
	public void testUpdateOthersInfo(){
		bike = bikeDao.findByCode("Honda001");
		othersInfo = bike.getListOthersInfo().get(0);
		othersInfo.setInfo("VELG R17 RACING ENKEI");
		assertEquals(othersInfoDao.update(othersInfo),true);
	}
	
	
	@Test
	public void testGetAllDataOtherInfo(){
		bike = bikeDao.findByCode("Honda001");
		assertEquals(othersInfoDao.getAllData(""+bike.getId()).size(),1);
	}
	
	@Test
	public void testSavePicture(){
		bike = bikeDao.findByCode("Honda001");
		pic = new Picture();
		pic.setCreatedBy("adm001");
		pic.setCreatedDate(new Date());
		pic.setPictureName("pic2");
		pic.setStatus("GENERAL");
		pic.setBike(bike);
		assertEquals(pictureDao.save(pic), true);
	}
	
	@Test
	public void testUpdatePicture(){
		bike = bikeDao.findByCode("Honda001");
		pic = bike.getListPicture().get(0);
		pic.setPictureName("Edited Picture");
		assertEquals(pictureDao.update(pic), true);
	}
	@Test
	public void testGetAllPictureData(){
		bike = bikeDao.findByCode("hnd004");
		assertEquals(pictureDao.getAllData(""+bike.getId()).size(),2);
	}
	
	
}
