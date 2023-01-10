package com.cg.eis.vaccination.dto;

import java.time.LocalDate;

import com.cg.eis.vaccination.entities.Slot;

public class AppointmentDto {
	 private long bookingId;
	 private String bookingStatus;
	 private int centerCode;
	 private long memberId;
	 private long mobileno;
	 private LocalDate dateofbooking;
	 private Slot slot;
	 
	 public AppointmentDto() {
	}
	public AppointmentDto(long bookingId, String bookingStatus, int centerCode, long memberId, long mobileno,
			LocalDate dateofbooking,Slot slot) {
		this.bookingId = bookingId;
		this.bookingStatus = bookingStatus;
		this.centerCode = centerCode;
		this.memberId = memberId;
		this.mobileno = mobileno;
		this.dateofbooking = dateofbooking;
		this.slot=slot;
	}
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public int getCenterCode() {
		return centerCode;
	}
	public void setCenterCode(int centerCode) {
		this.centerCode = centerCode;
	}
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public LocalDate getDateofbooking() {
		return dateofbooking;
	}
	public void setDateofbooking(LocalDate dateofbooking) {
		this.dateofbooking = dateofbooking;
	}
	public Slot getSlot() {
		return slot;
	}
	public void setSlot(Slot slot) {
		this.slot = slot;
	}
	 
	}

