package com.cg.eis.vaccination.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.eis.vaccination.entities.IdCard;
import com.cg.eis.vaccination.repositories.IdCardRepository;

@Service
public class IdCardServiceImpl implements IdCardService {
	@Autowired
	IdCardRepository idCardRepo;
	
	@Override
	public IdCard addIdCard(IdCard idcard) {
		return idCardRepo.save(idcard);
		
	}

	@Override
	public IdCard getAdharCardByNo(long aadharNo) {
		return idCardRepo.getAdharCardByNo(aadharNo);
	}
	@Override
	public List<IdCard> getAllIdCards() {
		
		return idCardRepo.findAll();
	}

	@Override
	public String deleteIdCard(long id) {
		if(idCardRepo.getAdharCardByNo(id)!=null)
		{
			idCardRepo.deleteById(id);
			return "deleted";
		}
		return "id not found";
	}


}
