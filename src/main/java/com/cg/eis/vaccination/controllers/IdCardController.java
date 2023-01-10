package com.cg.eis.vaccination.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.eis.vaccination.entities.IdCard;
import com.cg.eis.vaccination.service.IdCardService;
import com.cg.eis.vaccination.utils.CardAlreadyExistException;
import com.cg.eis.vaccination.utils.CardNotFoundException;

@RestController
@RequestMapping("/IdCard")
public class IdCardController {

	@Autowired
	IdCardService idcs;

	@PostMapping
	public ResponseEntity<IdCard> addIdCard(@RequestBody IdCard idcard)
	{
		IdCard val=idcs.getAdharCardByNo(idcard.getAadharNo());
		if(val!=null)
		{
			throw new CardAlreadyExistException();
		}
		 
		 return new ResponseEntity<IdCard>(idcs.addIdCard(idcard),HttpStatus.OK);
	}



	@GetMapping("/{aadharNo}")
	public ResponseEntity<IdCard> getAdharCardByNo(@PathVariable long aadharNo)
	{
		IdCard list=idcs.getAdharCardByNo(aadharNo);
		if(list==null)
			throw new CardNotFoundException();
		return new ResponseEntity<IdCard>(list,HttpStatus.OK);
		
	}
	@GetMapping 
	public ResponseEntity<List<IdCard>> getAllIdCards() {
		List<IdCard> list=idcs.getAllIdCards();
		if(list.isEmpty())
			throw new CardNotFoundException();
		return new ResponseEntity<List<IdCard>>(idcs.getAllIdCards(),HttpStatus.OK);
}
	@DeleteMapping("/id/{aadharno}")
	public ResponseEntity<String> deleteIdCard(@PathVariable long aadharno)
	{
		return new ResponseEntity<String>(idcs.deleteIdCard(aadharno),HttpStatus.OK);
	}


}

