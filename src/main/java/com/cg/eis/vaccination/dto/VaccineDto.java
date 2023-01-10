package com.cg.eis.vaccination.dto;

public class VaccineDto {

	private int centerCode;
	private int vaccineId;
	private String vaccineName;
	private String description;
	private int quantity;
	private double price;
	
	public VaccineDto() {}
	
	public VaccineDto(int centerCode, int vaccineId, String vaccineName, String description, int quantity,
			double price) {
		super();
		this.centerCode = centerCode;
		this.vaccineId = vaccineId;
		this.vaccineName = vaccineName;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}

	public int getCenterCode() {
		return centerCode;
	}
	public void setCenterCode(int centerCode) {
		this.centerCode = centerCode;
	}
	public int getVaccineId() {
		return vaccineId;
	}
	public void setVaccineId(int vaccineId) {
		this.vaccineId = vaccineId;
	}
	public String getVaccineName() {
		return vaccineName;
	}
	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
