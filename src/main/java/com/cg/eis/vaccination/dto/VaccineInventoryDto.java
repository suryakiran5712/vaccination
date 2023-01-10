package com.cg.eis.vaccination.dto;

import java.time.LocalDate;
import java.util.List;

public class VaccineInventoryDto {
	private long vaccineInventoryId;
	private int centerCode;
	private List<Integer> vaccineIdlist;
	private LocalDate vaccinedate;
	public VaccineInventoryDto() {
		// TODO Auto-generated constructor stub
	}
	public VaccineInventoryDto(long vaccineInventoryId, int centerCode, List<Integer> vaccineIdlist,LocalDate vaccinedate) {
		this.vaccineInventoryId = vaccineInventoryId;
		this.centerCode = centerCode;
		this.vaccineIdlist = vaccineIdlist;
		this.vaccinedate=vaccinedate;
	}
	public long getVaccineInventoryId() {
		return vaccineInventoryId;
	}
	public void setVaccineInventoryId(long vaccineInventoryId) {
		this.vaccineInventoryId = vaccineInventoryId;
	}
	public int getCenterCode() {
		return centerCode;
	}
	public void setCenterCode(int centerCode) {
		this.centerCode = centerCode;
	}
	public List<Integer> getVaccineIdlist() {
		return vaccineIdlist;
	}
	public void setVaccineIdlist(List<Integer> vaccineIdlist) {
		this.vaccineIdlist = vaccineIdlist;
	}
	public LocalDate getVaccinedate() {
		return vaccinedate;
	}
	public void setVaccinedate(LocalDate vaccinedate) {
		this.vaccinedate = vaccinedate;
	}
	
	
}
