package com.farm.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "phone_details")
public class PhoneDetailsEntity {

	@Id
	@SequenceGenerator(name = "farmSequence", sequenceName = "farmSequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "farmSequence")
	@Column(name = "phone_details_id")
	private Long id;

	@Column(name = "phone_number")
	private String number;

	@ManyToOne()
	@JoinColumn(name = "phone_user_id")
	private UserEntity user;

	public PhoneDetailsEntity() {
		super();
	}

	public PhoneDetailsEntity( String number, UserEntity user) {
		super();
		this.number = number;
		this.user = user;
	}
	
	public PhoneDetailsEntity(Long id, String number, UserEntity user) {
		super();
		this.id = id;
		this.number = number;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
