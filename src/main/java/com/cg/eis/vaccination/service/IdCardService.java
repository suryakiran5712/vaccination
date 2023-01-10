package com.cg.eis.vaccination.service;

import java.util.List;

import com.cg.eis.vaccination.entities.IdCard;

public interface IdCardService {
	public IdCard addIdCard (IdCard idcard);	
	public IdCard getAdharCardByNo(long adharno);
	public List<IdCard> getAllIdCards();
	public String deleteIdCard(long id);
}

