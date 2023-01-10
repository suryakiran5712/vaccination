package com.cg.eis.vaccination.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.eis.vaccination.entities.VaccinationCenter;
import com.cg.eis.vaccination.repositories.VaccinationCenterRepository;
import com.cg.eis.vaccination.utils.NoVaccinationCenterFoundException;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService{

	@Autowired
	VaccinationCenterRepository vcrepo;

	@Override
	public VaccinationCenter addVaccineCenter(VaccinationCenter center) {
		
		return vcrepo.save(center);
	}

	@Override
	public VaccinationCenter updateVaccineCenter(VaccinationCenter center) {
		if(vcrepo.existsById(center.getCode()))
			return vcrepo.save(center);
		return null;
	}

	@Override
	public String deleteVaccineCenter(int centerid) {
		VaccinationCenter val=vcrepo.getByCenterId(centerid);
		if(val==null)
		{
			return "delete failed";
		}
		try {
		vcrepo.deleteByid(centerid);
		return "delete Successful";
		}
		catch(Exception e)
		{
			return "Delete all dependencies and try again";
		}
		
	}

	@Override
	public VaccinationCenter getVaccineCenter(int centerid) {
		
		return vcrepo.getByCenterId(centerid);
	}

	@Override
	public List<VaccinationCenter> getAllVaccineCenters() {
		
		return vcrepo.findAll();
	}

}
