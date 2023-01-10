package com.cg.eis.vaccination.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.eis.vaccination.dto.AppointmentDto;
import com.cg.eis.vaccination.entities.Appointment;
import com.cg.eis.vaccination.service.AppointmentService;
import com.cg.eis.vaccination.utils.AppAlreadyExistException;
import com.cg.eis.vaccination.utils.AppNotFoundException;
import com.cg.eis.vaccination.utils.VaccinationInvalidDetailsException;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

@Autowired
AppointmentService vrserv;

@PostMapping
public ResponseEntity<Appointment> addAppointment(@RequestBody AppointmentDto reg)
{
	Appointment val=vrserv.getAppointment(reg.getBookingId());
	if(val!=null)
		throw new AppAlreadyExistException();
	Appointment vacReg=vrserv.addAppointment(reg);
	if(vacReg==null)
	{
		throw new VaccinationInvalidDetailsException();
	}
	return new ResponseEntity<Appointment>(vacReg,HttpStatus.OK);
}
@PutMapping
public ResponseEntity<Appointment> updateAppointment(@RequestBody AppointmentDto app)
{
	Appointment val=vrserv.getAppointment(app.getBookingId());
	if(val==null)
		throw new AppNotFoundException();
	Appointment appointment=vrserv.updateAppointment(app);
	if(appointment==null)
	{
		throw new VaccinationInvalidDetailsException();
	}
	return new ResponseEntity<Appointment>(appointment,HttpStatus.OK);
}
@GetMapping("/{bookingid}")
public ResponseEntity<Appointment> getAppointment(@PathVariable long bookingid)
{
	Appointment val=vrserv.getAppointment(bookingid);
	if(val==null)
		throw new AppNotFoundException();
	return new ResponseEntity<Appointment>(vrserv.getAppointment(bookingid),HttpStatus.OK);
}
@DeleteMapping("/delete/{bookingid}")
public ResponseEntity<String> deleteAppointment(@PathVariable long bookingid)
{
	return new ResponseEntity<String>(vrserv.deleteAppointment(bookingid),HttpStatus.OK);
}
@GetMapping
public ResponseEntity<List<Appointment>> getAllAppointment()
{
	List<Appointment> val=vrserv.getAllAppointment();
	if(val.isEmpty())
		throw new AppNotFoundException();
	return new ResponseEntity<List<Appointment>>(val,HttpStatus.OK);
}



}
