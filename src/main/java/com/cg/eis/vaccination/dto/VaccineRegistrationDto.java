package com.cg.eis.vaccination.dto;

import java.time.LocalDate;
import java.util.List;

public class VaccineRegistrationDto {
	private long registrationId;
	private List<Long> memberIdList;
    private long mobileNo;
    private LocalDate date;
    public VaccineRegistrationDto() {
		// TODO Auto-generated constructor stub
	}
    
	public long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(long registrationId) {
		this.registrationId = registrationId;
	}

	public VaccineRegistrationDto(long registrationId, List<Long> memberIdList, long mobileNo,LocalDate date) {
		this.registrationId = registrationId;
		this.memberIdList = memberIdList;
		this.mobileNo = mobileNo;
		this.date=date;
	}

	public List<Long> getMemberIdList() {
		return memberIdList;
	}

	public void setMemberIdList(List<Long> memberIdList) {
		this.memberIdList = memberIdList;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
