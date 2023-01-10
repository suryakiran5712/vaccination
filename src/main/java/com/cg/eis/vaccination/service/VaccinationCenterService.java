package com.cg.eis.vaccination.service;

import java.util.List;

import com.cg.eis.vaccination.entities.VaccinationCenter;

public interface VaccinationCenterService {
	public VaccinationCenter addVaccineCenter(VaccinationCenter center);
	public VaccinationCenter updateVaccineCenter(VaccinationCenter center);
	public String deleteVaccineCenter(int code);
	public VaccinationCenter getVaccineCenter(int centerid);
	public List<VaccinationCenter> getAllVaccineCenters();

}
