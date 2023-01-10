package com.cg.eis.vaccination.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import com.cg.eis.vaccination.dto.VaccineInventoryDto;
import com.cg.eis.vaccination.entities.IdCard;
import com.cg.eis.vaccination.entities.VaccineInventory;
import com.cg.eis.vaccination.service.VaccineInventoryService;
import com.cg.eis.vaccination.utils.CardNotFoundException;
import com.cg.eis.vaccination.utils.VaccinationInvalidDetailsException;
import com.cg.eis.vaccination.utils.VaccineInventoryAlreadyExists;
import com.cg.eis.vaccination.utils.VaccineInventoryNotFoundException;

@RestController
@RequestMapping("/vaccineinventory")
public class VaccineInventoryController {
@Autowired
VaccineInventoryService viserv;
	
	@PostMapping
	public ResponseEntity<VaccineInventory> addVaccineCount(@RequestBody VaccineInventoryDto inv)
	{
		VaccineInventory val=viserv.getVaccineInventoryByCenter(inv.getVaccineInventoryId());
		if(val!=null)
		{
		throw new VaccineInventoryAlreadyExists();
		}
		VaccineInventory vc=viserv.addVaccineCount(inv);
		if(vc==null)
		{
			throw new VaccinationInvalidDetailsException();	
		}
		return new ResponseEntity<VaccineInventory>(vc,HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<VaccineInventory> updateVaccineInventory(@RequestBody VaccineInventoryDto inv)
	{
		VaccineInventory val=viserv.getVaccineInventoryByCenter(inv.getCenterCode());
		if(val==null)
			throw new VaccineInventoryNotFoundException();
		return new ResponseEntity<VaccineInventory>(viserv.updateVaccineInventory(inv),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteVaccineInventory(@PathVariable int id)
	{
		return new ResponseEntity<String>(viserv.deleteVaccineInventory(id),HttpStatus.OK);
	}
	@GetMapping("/centerid/{id}")
	public ResponseEntity<VaccineInventory> getVaccineInventoryByCenter(@PathVariable int id)
	{
		VaccineInventory val=viserv.getVaccineInventoryByCenter(id);
		if(val==null)
			throw new VaccineInventoryNotFoundException();
		return new ResponseEntity<VaccineInventory>(viserv.getVaccineInventoryByCenter(id),HttpStatus.OK);
	}
	@GetMapping("/date/{date}")
	public ResponseEntity<List<VaccineInventory>> getVaccineInventoryByDate(String date)
	{
		DateTimeFormatter form=DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String da=date;
		LocalDate ld=LocalDate.parse(da,form);
		List<VaccineInventory> list=viserv.getVaccineInventoryByDate(ld);
		if(list.isEmpty())
			throw new VaccineInventoryNotFoundException();
		return new ResponseEntity<List<VaccineInventory>>(list,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<VaccineInventory>> getAllVaccineInventory()
	{
		List<VaccineInventory> list=viserv.getAllVaccineInventory();
		if(list.isEmpty())
			throw new VaccineInventoryNotFoundException();
		return new ResponseEntity<List<VaccineInventory>>(viserv.getAllVaccineInventory(),HttpStatus.OK);
	}
}

