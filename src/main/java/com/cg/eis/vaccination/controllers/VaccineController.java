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

import com.cg.eis.vaccination.dto.VaccineDto;
import com.cg.eis.vaccination.entities.Vaccine;
import com.cg.eis.vaccination.service.VaccineService;
import com.cg.eis.vaccination.utils.FillInventoryDetailsException;
import com.cg.eis.vaccination.utils.NoRecordsFoundException;
import com.cg.eis.vaccination.utils.VaccineAlreadyExistException;
import com.cg.eis.vaccination.utils.VaccineNotFoundException;

@RestController
@RequestMapping("/vaccine")
public class VaccineController {

	@Autowired
	VaccineService vacservice;

	@PostMapping
	public ResponseEntity<Vaccine> addVaccine(@RequestBody VaccineDto vaccine) 
	{
		Vaccine v1=vacservice.getVaccineById(vaccine.getVaccineId());
		if(v1!=null)
		{
			throw new VaccineAlreadyExistException();
		}
		Vaccine vac=vacservice.addVaccine(vaccine);
		if(vac==null)
		{
			throw new FillInventoryDetailsException();
		}
		return new ResponseEntity<Vaccine>(vac,HttpStatus.OK);
		
	}
	
	@PutMapping
	public ResponseEntity<Vaccine> updateVaccine(@RequestBody Vaccine vaccine)
	{
		Vaccine val=vacservice.getVaccineById(vaccine.getVaccineId());
		if(val==null)
			throw new VaccineNotFoundException();
		
		return new ResponseEntity<Vaccine>(vacservice.updateVaccine(vaccine),HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Vaccine> getVaccineById(@PathVariable int id)
	{
		Vaccine list=vacservice.getVaccineById(id);
		if(list==null)
			throw new VaccineNotFoundException();
		return new ResponseEntity<Vaccine>(list,HttpStatus.OK);
	}
	
	@GetMapping("/get/{name}")
	public ResponseEntity<Vaccine> getVaccineByName(@PathVariable String name)
	{
		Vaccine list=vacservice.getVaccineByName(name);
		if(list==null)
			throw new VaccineNotFoundException();
		return new ResponseEntity<Vaccine>(list,HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Vaccine>> getAllVaccine()
	{
		List<Vaccine>list=vacservice.getAllVaccine();
		if(list.isEmpty())
			throw new NoRecordsFoundException();
		return new ResponseEntity<List<Vaccine>>(list,HttpStatus.OK);
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<String> deleteVaccine(@PathVariable int id)
	{
		String status=vacservice.deleteVaccine(id);
		return new ResponseEntity<String>(status,HttpStatus.OK);
	}

}
