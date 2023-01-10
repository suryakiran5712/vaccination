package com.cg.eis.vaccination.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vaccine")
public class Vaccine {

	@Id
	private int vaccineId;
	@Column(length = 30)
	private String vaccineName;
	@Column(length = 30)
	private String description;    
	@Column
	int quantity;
	@Column
	double price;
	public Vaccine() {}
	public Vaccine(int vaccineId, String vaccineName, String description, int quantity, double price) {
		super();
		this.vaccineId = vaccineId;
		this.vaccineName = vaccineName;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
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
	@Override
	public String toString() {
		return "Vaccine [vaccineId=" + vaccineId + ", vaccineName=" + vaccineName + ", description=" + description
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}
	
}
