package com.assaifiy.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="motorcycle")
public class Bike implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2431288722469738433L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="motor_id")
	private int id;
	
	@Column(name="motor_code")
	private String bikeCode;
	
	@Column(name="ad_title")
	private String adTitle;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="type")
	private String type;
	
	@Column(name="plate_number")
	private String plateNumber;
	
	@Column(name="year")
	private String year;
	
	@Column(name="color")
	private String color;
	
	@Column(name="tax_expense")
	private Date taxExpense;
	
	@Column(name="vehicle_ownership")
	private String vehicleOwnership;
	
	@Column(name="mileage")
	private String mileage;
	
	@Column(name="letters_completeness")
	private String lettersCompleteness;
	
	
	@Column(name="payment")
	private String payment;
	
	@Column(name="additional_info")
	private String additionalInfo;
	
	@Column(name="status")
	private String status;
	
	@Column(name="price")
	private int price;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="subcategory_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private SubCategory subCategory;
	
	@OneToMany(mappedBy="bike")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","bike"})
	private List<OthersInfo> listOthersInfo;
	
	@OneToMany(mappedBy="bike")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","bike"})
	private List<Picture> listPicture;

	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBikeCode() {
		return bikeCode;
	}

	public void setBikeCode(String bikeCode) {
		this.bikeCode = bikeCode;
	}

	public String getAdTitle() {
		return adTitle;
	}

	public void setAdTitle(String adTitle) {
		this.adTitle = adTitle;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getTaxExpense() {
		return taxExpense;
	}

	public void setTaxExpense(Date taxExpense) {
		this.taxExpense = taxExpense;
	}

	public String getVehicleOwnership() {
		return vehicleOwnership;
	}

	public void setVehicleOwnership(String vehicleOwnership) {
		this.vehicleOwnership = vehicleOwnership;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public String getLettersCompleteness() {
		return lettersCompleteness;
	}

	public void setLettersCompleteness(String lettersCompleteness) {
		this.lettersCompleteness = lettersCompleteness;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public List<OthersInfo> getListOthersInfo() {
		return listOthersInfo;
	}

	public void setListOthersInfo(List<OthersInfo> listOthersInfo) {
		this.listOthersInfo = listOthersInfo;
	}

	public List<Picture> getListPicture() {
		return listPicture;
	}

	public void setListPicture(List<Picture> listPicture) {
		this.listPicture = listPicture;
	}
	
	
}
