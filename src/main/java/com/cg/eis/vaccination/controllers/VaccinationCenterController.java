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

import com.cg.eis.vaccination.entities.VaccinationCenter;
import com.cg.eis.vaccination.service.VaccinationCenterService;
import com.cg.eis.vaccination.utils.NoVaccinationCenterFoundException;
import com.cg.eis.vaccination.utils.VaccinationCenterAlreadyExistException;
import com.cg.eis.vaccination.utils.VaccinationCenterNotFoundException;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {

	@Autowired
	VaccinationCenterService vcservice;
	
	@PostMapping
	public ResponseEntity<VaccinationCenter> addVaccineCenter(@RequestBody VaccinationCenter center)
	{
		
		VaccinationCenter val=vcservice.getVaccineCenter(center.getCode());
		if(val!=null)
		{
			throw new VaccinationCenterAlreadyExistException();
		}
		
		return new ResponseEntity<VaccinationCenter>(vcservice.addVaccineCenter(center),HttpStatus.OK);
		
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<VaccinationCenter> getVaccineCenter(@PathVariable int code)
	{
		VaccinationCenter val=vcservice.getVaccineCenter(code);
		if(val==null)
			throw new VaccinationCenterNotFoundException();
		return new ResponseEntity<VaccinationCenter>(val,HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<String> updateVaccineCenter(@RequestBody VaccinationCenter center)
	{
		VaccinationCenter val=vcservice.getVaccineCenter(center.getCode());
		if(val==null)
			throw new VaccinationCenterNotFoundException();
		vcservice.updateVaccineCenter(center);
		return new ResponseEntity<String>("Updated successfully",HttpStatus.OK);
		
	}
	
	@DeleteMapping("/del/{centerid}")
	public ResponseEntity<String> deleteVaccineCenter(@PathVariable int centerid)
	{
		String status=vcservice.deleteVaccineCenter(centerid);
		return new ResponseEntity<String>(status,HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<VaccinationCenter>> getAllVaccineCenters()
	{
		List<VaccinationCenter>list=vcservice.getAllVaccineCenters();
		if(list.isEmpty())
			throw new NoVaccinationCenterFoundException();
		return new ResponseEntity<List<VaccinationCenter>>(list,HttpStatus.OK);
	}
}

