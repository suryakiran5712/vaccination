package com.cg.eis.vaccination.dto;

import java.time.LocalDate;

public class MemberDto {
	private long memberId;
	private Long aadharNo;
	private String dose1status;
	private String dose2status;
	private	LocalDate dose1date;
	private	LocalDate dose2date;
	private int vaccineId;
	private int vaccineRegistrationId;
	public MemberDto() {
	}
	public MemberDto(long memberId,Long aadharNo, String dose1status, String dose2status, LocalDate dose1date, LocalDate dose2date,
			int vaccineId, int vaccineRegistrationId) {
		this.memberId=memberId;
		this.aadharNo = aadharNo;
		this.dose1status = dose1status;
		this.dose2status = dose2status;
		this.dose1date = dose1date;
		this.dose2date = dose2date;
		this.vaccineId = vaccineId;
		this.vaccineRegistrationId=vaccineRegistrationId;
	}
	public Long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(Long aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getDose1status() {
		return dose1status;
	}
	public void setDose1status(String dose1status) {
		this.dose1status = dose1status;
	}
	public String getDose2status() {
		return dose2status;
	}
	public void setDose2status(String dose2status) {
		this.dose2status = dose2status;
	}
	public LocalDate getDose1date() {
		return dose1date;
	}
	public void setDose1date(LocalDate dose1date) {
		this.dose1date = dose1date;
	}
	public LocalDate getDose2date() {
		return dose2date;
	}
	public void setDose2date(LocalDate dose2date) {
		this.dose2date = dose2date;
	}
	public int getVaccineId() {
		return vaccineId;
	}
	public void setVaccineId(int vaccineId) {
		this.vaccineId = vaccineId;
	}
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public int getVaccineRegistrationId() {
		return vaccineRegistrationId;
	}
	public void setVaccineRegistrationId(int vaccineRegistrationId) {
		this.vaccineRegistrationId = vaccineRegistrationId;
	}
	
	
}
