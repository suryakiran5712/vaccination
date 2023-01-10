package com.cg.eis.vaccination.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.eis.vaccination.dto.VaccineInventoryDto;
import com.cg.eis.vaccination.entities.VaccinationCenter;
import com.cg.eis.vaccination.entities.Vaccine;
import com.cg.eis.vaccination.entities.VaccineInventory;
import com.cg.eis.vaccination.repositories.VaccinationCenterRepository;
import com.cg.eis.vaccination.repositories.VaccineInventoryRepository;
import com.cg.eis.vaccination.repositories.VaccineRepository;

@Service
public class VaccineInventoryServiceImpl implements VaccineInventoryService{
@Autowired
VaccinationCenterRepository vcRepo;

@Autowired
VaccineRepository vRepo;

@Autowired
VaccineInventoryRepository viRepo;
	@Override
	public VaccineInventory addVaccineCount(VaccineInventoryDto invdto) {
		VaccinationCenter vc=vcRepo.getByCenterId(invdto.getCenterCode());
		if(vc==null)
		{
			return null;
		}
		List<Vaccine> vlist=new ArrayList<>();
		for(int i:invdto.getVaccineIdlist())
		{
			if(vRepo.getVaccineById(i)==null)
			{
				continue;
			}
			Vaccine v=vRepo.getVaccineById(i);
			vlist.add(v);
		}
		VaccineInventory vinv=new VaccineInventory(invdto.getVaccineInventoryId(),vc,vlist,invdto.getVaccinedate());
		return viRepo.save(vinv);	

	}
	@Override
	public VaccineInventory updateVaccineInventory(VaccineInventoryDto invdto) {
		VaccinationCenter vc=vcRepo.getByCenterId(invdto.getCenterCode());
		List<Vaccine> vlist=new ArrayList<>();
		if(! invdto.getVaccineIdlist().isEmpty())
		{
			for(int i:invdto.getVaccineIdlist())
			{
				if(vRepo.getVaccineById(i)==null)
				{
					return null;
				}
				Vaccine v=vRepo.getVaccineById(i);
				vlist.add(v);
			}
		}
		VaccineInventory vinv=new VaccineInventory(invdto.getVaccineInventoryId(),vc,vlist,invdto.getVaccinedate());
		return viRepo.save(vinv);
	}

	@Override
	public String deleteVaccineInventory(long vaccineInventoryId) {
		
		VaccineInventory inv=viRepo.getById(vaccineInventoryId);
		if(inv!=null)
		{
		try {
			viRepo.deleteByid(vaccineInventoryId);
			return "delete Successful..";
			}
		catch(Exception e)
		{
			return "please delete all dependencies and try again";
		}
		}
		return "delete failed";
	}

	@Override
	public VaccineInventory getVaccineInventoryByCenter(long centerid) {
		
		return viRepo.getVaccineInventoryByCenter(centerid);
	}

	@Override
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate date) {
		return viRepo.getVaccineInventoryByDate(date);
	}

	@Override
	public List<VaccineInventory> getAllVaccineInventory() {
		return viRepo.getAllVaccineInventory();
	}

}
