package com.cg.eis.vaccination.service;

import java.util.List;

import com.cg.eis.vaccination.dto.VaccineDto;
import com.cg.eis.vaccination.entities.Vaccine;

public interface VaccineService {
	public Vaccine addVaccine(VaccineDto vaccine);
	public Vaccine updateVaccine(Vaccine vaccine);
	public String deleteVaccine(int id);
	public Vaccine getVaccineByName(String vaccinName);
	public Vaccine getVaccineById(int vaccineId);
	public List<Vaccine> getAllVaccine();
}
