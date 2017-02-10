package com.model;

import javax.persistence.*;

@Entity
@Table(name = "tblAddress")
public class PersonAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "streetNumber")
	private int streetNumber;

	@Column(name = "barangay")
	private String barangay;

	@Column(name = "city")
	private String city;
	
	@Column(name = "zipcode")
	private int zipCode;

	public PersonAddress() {}

	public PersonAddress(int stNumber_param, String brgy_param, String city_param, int zipcode_param) {
		
		this.setStreetNumber(stNumber_param);
		this.setBarangay(brgy_param);
		this.setCity(city_param);
		this.setZipCode(zipcode_param);
	}

	public void setId(int id_param) {
		this.id = id_param;
	}

	public void setStreetNumber(int stNumber_param) {
		this.streetNumber = stNumber_param;
	}

	public void setBarangay(String brgy_param) {
		this.barangay = brgy_param;
	}

	public void setCity(String city_param) {
		this.city = city_param;
	}

	public void setZipCode(int zipcode_param) {
		this.zipCode = zipcode_param;
	}

	public int getId() {
		return this.id;
	}

	public int getStreetNumber() {
		return this.streetNumber;
	}

	public String getBarangay() {
		return this.barangay;
	}

	public String getCity() {
		return this.city;
	}

	public int getZipCode() {
		return this.zipCode;
	}

}