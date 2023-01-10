package com.cg.eis.vaccination.service;

import java.util.List;

import com.cg.eis.vaccination.dto.AppointmentDto;
import com.cg.eis.vaccination.entities.Appointment;

public interface AppointmentService {
	public Appointment addAppointment(AppointmentDto app);
	public Appointment updateAppointment(AppointmentDto app);
	public String deleteAppointment(long bookingid);
	public Appointment getAppointment(long bookingid);
	public List<Appointment> getAllAppointment();
}
