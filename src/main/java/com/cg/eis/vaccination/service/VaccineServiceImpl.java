package com.cg.eis.vaccination.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.eis.vaccination.dto.VaccineDto;
import com.cg.eis.vaccination.entities.Vaccine;
import com.cg.eis.vaccination.entities.VaccineInventory;
import com.cg.eis.vaccination.repositories.VaccinationCenterRepository;
import com.cg.eis.vaccination.repositories.VaccineInventoryRepository;
import com.cg.eis.vaccination.repositories.VaccineRepository;

@Service
public class VaccineServiceImpl implements VaccineService{

	@Autowired
	VaccinationCenterRepository vcRepo;
	@Autowired
	VaccineRepository vaccinerepo;
	@Autowired
	VaccineInventoryRepository viRepo;
	
	@Override
	public Vaccine addVaccine(VaccineDto vaccine) {
		VaccineInventory vi=viRepo.getVaccineInventoryByCenter(vaccine.getCenterCode());
		if(vi==null)
		{
			return null;
		}
		Vaccine vac=new Vaccine(vaccine.getVaccineId(),vaccine.getVaccineName(),
				vaccine.getDescription(),vaccine.getQuantity(),vaccine.getPrice());
		vi.getVaccinelist().add(vac);
		viRepo.save(vi);
		return vaccinerepo.save(vac);	
	}

	@Override
	public Vaccine updateVaccine(Vaccine vaccine) {
		if(vaccinerepo.existsById(vaccine.getVaccineId()))
		{
			return vaccinerepo.save(vaccine);
		}
		return null;
	}

	@Override
	public String deleteVaccine(int id) {
		if(vaccinerepo.existsById(id))
		try
		{
		vaccinerepo.deleteById(id);
		return "delete successful";
		}
		catch(Exception e)
		{
			return "please delete all dependencies and try again";
		}
		return "delete unsuccesful";
	}

	@Override
	public Vaccine getVaccineByName(String vaccinName) {

		return vaccinerepo.getVaccineByName(vaccinName);
	}

	@Override
	public Vaccine getVaccineById(int vaccineId) {
		
		return vaccinerepo.getVaccineById(vaccineId);
	}

	@Override
	public List<Vaccine> getAllVaccine() {
		
		return vaccinerepo.findAll();
	}

}
