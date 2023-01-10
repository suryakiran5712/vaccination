package com.cg.eis.vaccination.service;

import java.util.List;

import com.cg.eis.vaccination.dto.VaccineRegistrationDto;
import com.cg.eis.vaccination.entities.Member;
import com.cg.eis.vaccination.entities.VaccineRegistration;

public interface VaccineRegistrationService {

	public VaccineRegistration addVaccineRegistration (VaccineRegistrationDto reg);
	public VaccineRegistration updateVaccineRegistration (VaccineRegistrationDto reg);
	public String deleteVaccineRegistration (long registrationId);
	public VaccineRegistration getVaccineRegistration (long registrationId);
	public List<Member> getAllMember(long mobileno);
	public List<VaccineRegistration> getAllVaccineRegistrations();
	public VaccineRegistration getByMobile(long mobileno);
}
