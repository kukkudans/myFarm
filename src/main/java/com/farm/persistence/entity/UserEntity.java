package com.farm.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@SequenceGenerator(name = "farmSequence", sequenceName = "farmSequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "farmSequence")
	@Column(name = "id")
	private Long id;

	@Column(name = "user_id")
	@NotNull
	private String userId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@OneToMany(mappedBy = "user",fetch=FetchType.EAGER)
	private List<PhoneDetailsEntity> phoneDetails;

//	@OneToOne()
//	@JoinColumn(name="address_id")
//	private AddressEntity address;
	

	public UserEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<PhoneDetailsEntity> getPhoneDetails() {
		return phoneDetails;
	}

	public void setPhoneDetails(List<PhoneDetailsEntity> phoneDetails) {
		this.phoneDetails = phoneDetails;
	}

//	public AddressEntity getAddress() {
//		return address;
//	}
//
//	public void setAddress(AddressEntity address) {
//		this.address = address;
//	}

}