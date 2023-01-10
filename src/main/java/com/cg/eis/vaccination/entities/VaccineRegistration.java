package com.cg.eis.vaccination.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="vaccineregistration")
public class VaccineRegistration {

	@Id
	long registrationId;
	@Column(length=10)
	long mobileno;
	@Column
	LocalDate dateofregistration;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="member")
	List<Member> memberlist;
	
	public VaccineRegistration() {}

	public VaccineRegistration(long registrationId, long mobileno, LocalDate dateofregistration,
			List<Member> memberlist) {
		super();
		this.registrationId = registrationId;
		this.mobileno = mobileno;
		this.dateofregistration = dateofregistration;
		this.memberlist = memberlist;
	}

	public long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(long registrationId) {
		this.registrationId = registrationId;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public LocalDate getDateofregistration() {
		return dateofregistration;
	}

	public void setDateofregistration(LocalDate dateofregistration) {
		this.dateofregistration = dateofregistration;
	}

	public List<Member> getMemberlist() {
		return memberlist;
	}

	public void setMemberlist(List<Member> memberlist) {
		this.memberlist = memberlist;
	}

	@Override
	public String toString() {
		return "VaccineRegistration [registrationId=" + registrationId + ", mobileno=" + mobileno
				+ ", dateofregistration=" + dateofregistration + ", memberlist=" + memberlist + "]";
	}
	
	
}
