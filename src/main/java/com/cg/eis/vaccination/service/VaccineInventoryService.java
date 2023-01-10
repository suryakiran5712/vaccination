package com.cg.eis.vaccination.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.eis.vaccination.dto.VaccineInventoryDto;
import com.cg.eis.vaccination.entities.VaccineInventory;

public interface VaccineInventoryService {

	public VaccineInventory updateVaccineInventory(VaccineInventoryDto inv);
	public String deleteVaccineInventory(long vaccineInventoryId);
	public VaccineInventory getVaccineInventoryByCenter(long l);
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate date);
	public List<VaccineInventory> getAllVaccineInventory();
	public VaccineInventory addVaccineCount(VaccineInventoryDto inv);

}
