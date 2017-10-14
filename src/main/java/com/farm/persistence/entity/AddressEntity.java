package com.farm.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address")
public class AddressEntity {

	@Id
	@SequenceGenerator(name = "farmSequence", sequenceName = "farmSequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "farmSequence")
	@Column(name = "address_id")
	private Long id;

	@Column(name = "floor_no")
	private String floorNO;

	@Column(name = "house_no")
	private String houseNo;

	@Column(name = "building_no")
	private String buildingNo;

	@Column(name = "landmark")
	private String landmark;

	@Column(name = "address_line")
	private String addressLine;

	@Column(name = "post_office")
	private String post_office;

	@Column(name = "pin")
	private Long pin;

	@Column(name = "district")
	private String district;

	@Column(name = "state")
	private String sate;

	@Column(name = "country")
	private String country;

	@NotNull
	@Column(name = "user_id")
	private String user;

	public AddressEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFloorNO() {
		return floorNO;
	}

	public void setFloorNO(String floorNO) {
		this.floorNO = floorNO;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getPost_office() {
		return post_office;
	}

	public void setPost_office(String post_office) {
		this.post_office = post_office;
	}

	public Long getPin() {
		return pin;
	}

	public void setPin(Long pin) {
		this.pin = pin;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getSate() {
		return sate;
	}

	public void setSate(String sate) {
		this.sate = sate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}