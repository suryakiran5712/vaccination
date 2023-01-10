package com.cg.eis.vaccination.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="member")
public class Member {

	@Id
	@Column(length=10)

	long memberId;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="aadharno",unique = true)
		private IdCard idcard;

	@Column(length=10)
	    private String dose1status;
	@Column(length=10)
		private String dose2status;
	@Column
		private	LocalDate dose1date;
	@Column
		private	LocalDate dose2date;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="vaccineId")
		private	Vaccine vaccine;
	public Member() {}
	public Member(long memberId, IdCard idcard, String dose1status, String dose2status, LocalDate dose1date,
			LocalDate dose2date, Vaccine vaccine) {
		super();
		this.memberId = memberId;
		this.idcard = idcard;
		this.dose1status = dose1status;
		this.dose2status = dose2status;
		this.dose1date = dose1date;
		this.dose2date = dose2date;
		this.vaccine = vaccine;
	}
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public IdCard getIdcard() {
		return idcard;
	}
	public void setIdcard(IdCard idcard) {
		this.idcard = idcard;
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
	public Vaccine getVaccine() {
		return vaccine;
	}
	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", idcard=" + idcard + ", dose1status=" + dose1status + ", dose2status="
				+ dose2status + ", dose1date=" + dose1date + ", dose2date=" + dose2date + ", vaccine=" + vaccine + "]";
	}
	
}
