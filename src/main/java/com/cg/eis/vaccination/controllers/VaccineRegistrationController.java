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

import com.cg.eis.vaccination.dto.VaccineRegistrationDto;
import com.cg.eis.vaccination.entities.Member;
import com.cg.eis.vaccination.entities.VaccineRegistration;
import com.cg.eis.vaccination.service.VaccineRegistrationService;
import com.cg.eis.vaccination.utils.NoMembersFoundException;
import com.cg.eis.vaccination.utils.VaccinationInvalidDetailsException;
import com.cg.eis.vaccination.utils.VaccineRegAlreadyExistException;
import com.cg.eis.vaccination.utils.VaccineRegNotFoundException;

@RestController
@RequestMapping("/vaccineregistration")
public class VaccineRegistrationController {
	@Autowired
	VaccineRegistrationService vrserv;

	@PostMapping
	public ResponseEntity<VaccineRegistration> addVaccineRegistration(@RequestBody VaccineRegistrationDto reg)
	{
		VaccineRegistration val=vrserv.getVaccineRegistration(reg.getRegistrationId());
		if(val!=null)
			throw new VaccineRegAlreadyExistException();
		VaccineRegistration vacReg=vrserv.addVaccineRegistration(reg);
		if(vacReg==null)
		{
			throw new VaccinationInvalidDetailsException();
		}
		return new ResponseEntity<VaccineRegistration>(vacReg,HttpStatus.OK);
	}
@PutMapping
public ResponseEntity<VaccineRegistration> updateVaccineRegistration(@RequestBody VaccineRegistrationDto reg)
{
	VaccineRegistration val=vrserv.getVaccineRegistration(reg.getRegistrationId());
	if(val==null)
		throw new VaccineRegNotFoundException();
	VaccineRegistration vacReg=vrserv.updateVaccineRegistration(reg);
	return new ResponseEntity<VaccineRegistration>(vacReg,HttpStatus.OK);
}
@DeleteMapping("/delete/{registrationId}")
public ResponseEntity<String> deleteVaccineRegistration (@PathVariable long registrationId)
{
	String status=vrserv.deleteVaccineRegistration(registrationId);
	return new ResponseEntity<String>(status,HttpStatus.OK);
}
@GetMapping("{registrationid}")
public ResponseEntity<VaccineRegistration> getVaccineRegistration (@PathVariable long registrationid)
{
	VaccineRegistration val=vrserv.getVaccineRegistration(registrationid);
	if(val==null)
		throw new VaccineRegNotFoundException();
	
	return new ResponseEntity<VaccineRegistration>(val,HttpStatus.OK);
}
@GetMapping("/memlis/{mobileno}")
public ResponseEntity<List<Member>> getAllMember(@PathVariable long mobileno)
{
	List<Member> val=vrserv.getAllMember(mobileno);
	if(val.isEmpty())
		throw new NoMembersFoundException();
	return new ResponseEntity<List<Member>>(vrserv.getAllMember(mobileno),HttpStatus.OK);
}
@GetMapping
public ResponseEntity<List<VaccineRegistration>> getAllVaccineRegistrations(){
	List<VaccineRegistration> list=vrserv.getAllVaccineRegistrations();
	if(list.isEmpty())
		throw new VaccineRegNotFoundException();
	return new ResponseEntity<List<VaccineRegistration>>(list,HttpStatus.OK);
}
}
