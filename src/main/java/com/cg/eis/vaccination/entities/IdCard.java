package com.cg.eis.vaccination.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="idcard")
public class IdCard {

	@Id
	private long aadharNo;
	@Column(length=30)
	private String name;
	@Column(length=10)
	private String gender;
	@Column(length=20)
	private String city;
	@Column(length=10)
	private String pincode;
	
	public IdCard() {}

	public IdCard(long aadharNo, String name, String gender, String city, String pincode) {
		super();
		this.aadharNo = aadharNo;
		this.name = name;
		this.gender = gender;
		this.city = city;
		this.pincode = pincode;
	}

	public long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "IdCard [aadharNo=" + aadharNo + ", name=" + name + ", gender=" + gender + ", city=" + city
				+ ", pincode=" + pincode + "]";
	}
	
}
