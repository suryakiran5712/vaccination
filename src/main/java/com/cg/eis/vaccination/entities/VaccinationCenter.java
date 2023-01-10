package com.cg.eis.vaccination.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="vaccinationcenter")
public class VaccinationCenter {
	@Id
	private int code;
    @Column(length = 30)
	private String centername;
    @Column(length = 30)
	private String address;
    @Column(length = 20)
	private String city;
    @Column(length = 20)
	private String state;
    @Column(length = 10)
	private String pincode;
    public VaccinationCenter() {}
	public VaccinationCenter(int code, String centername, String address, String city, String state, String pincode) {
		super();
		this.code = code;
		this.centername = centername;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getCentername() {
		return centername;
	}
	public void setCentername(String centername) {
		this.centername = centername;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "VaccinationCenter [code=" + code + ", centername=" + centername + ", address=" + address + ", city="
				+ city + ", state=" + state + ", pincode=" + pincode + "]";
	}
    
}
