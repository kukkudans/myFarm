package com.farm.rest.dto;

public class UserAddressDto {
	private String userId;
	private String floorNO;
	private String houseNo;
	private String buildingNo;
	private String landmark;
	private String addressLine;
	private String post_office;
	private Long pin;
	private String district;
	private String sate;
	private String country;

	public UserAddressDto() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

}
