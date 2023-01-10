package com.cg.eis.vaccination.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="vaccineinventory")
public class VaccineInventory {
	@Id
	private long vaccineInventoryId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="centerCode",unique = true)
	private VaccinationCenter center;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="vaccine")
	private List<Vaccine> vaccinelist;
	@Column
	private LocalDate vaccinedate;
	public VaccineInventory() {}
	public VaccineInventory(long vaccineInventoryId, VaccinationCenter center, List<Vaccine> vaccinelist,
			LocalDate vaccinedate) {
		super();
		this.vaccineInventoryId = vaccineInventoryId;
		this.center = center;
		this.vaccinelist = vaccinelist;
		this.vaccinedate = vaccinedate;
	}
	public long getVaccineInventoryId() {
		return vaccineInventoryId;
	}
	public void setVaccineInventoryId(long vaccineInventoryId) {
		this.vaccineInventoryId = vaccineInventoryId;
	}
	public VaccinationCenter getCenter() {
		return center;
	}
	public void setCenter(VaccinationCenter center) {
		this.center = center;
	}
	public List<Vaccine> getVaccinelist() {
		return vaccinelist;
	}
	public void setVaccinelist(List<Vaccine> vaccinelist) {
		this.vaccinelist = vaccinelist;
	}
	public LocalDate getVaccinedate() {
		return vaccinedate;
	}
	public void setVaccinedate(LocalDate vaccinedate) {
		this.vaccinedate = vaccinedate;
	}
	@Override
	public String toString() {
		return "VaccineInventory [vaccineInventoryId=" + vaccineInventoryId + ", center=" + center + ", vaccinelist="
				+ vaccinelist + ", vaccinedate=" + vaccinedate + "]";
	}
	
}
