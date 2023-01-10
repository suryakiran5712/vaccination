package com.cg.eis.vaccination.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.eis.vaccination.dto.VaccineRegistrationDto;
import com.cg.eis.vaccination.entities.Member;
import com.cg.eis.vaccination.entities.VaccineRegistration;
import com.cg.eis.vaccination.repositories.MemberRepository;
import com.cg.eis.vaccination.repositories.VaccineRegistrationRepository;

@Service
public class VaccineRegistrationServiceImpl implements VaccineRegistrationService{
	@Autowired
	MemberRepository memRepo;
	@Autowired
	VaccineRegistrationRepository vrrepo;

	
	@Override
	public VaccineRegistration addVaccineRegistration(VaccineRegistrationDto reg) {
		List<Member> memList=new ArrayList<>();
		if(! reg.getMemberIdList().isEmpty())
		{
			for(long id:reg.getMemberIdList())
			{
				if(memRepo.getMemberById(id)==null)
				{
					return null;
				}
				memList.add(memRepo.getMemberById(id));
				
				
			}
		}
		VaccineRegistration vacReg=new VaccineRegistration(reg.getRegistrationId(),reg.getMobileNo(),reg.getDate(),memList);
		
		return vrrepo.save(vacReg);	
	}
	@Override
	public VaccineRegistration updateVaccineRegistration(VaccineRegistrationDto reg) {
		if(vrrepo.existsById(reg.getRegistrationId()))
		{
			List<Member> memList=new ArrayList<>();
			if(! reg.getMemberIdList().isEmpty())
			{
			for(long id:reg.getMemberIdList())
			{
				if(memRepo.getMemberById(id)==null)
				{
					return null;
				}
				memList.add(memRepo.getMemberById(id));
			}
			}
			VaccineRegistration vacReg=vrrepo.getByRegistrationId(reg.getRegistrationId());
			vacReg.setDateofregistration(reg.getDate());
			vacReg.setMemberlist(memList);
			vacReg.setMobileno(reg.getMobileNo());
			return vrrepo.save(vacReg);
		}
		return null;
	}

	@Override
	public String deleteVaccineRegistration(long registrationId) {
		if(vrrepo.existsById(registrationId))
		{
			try {
			vrrepo.deleteByid(registrationId);
			return "delete successful";
			}
			catch(Exception o)
			{
				return "please delete all dependencies and try again";
			}
		}
		
		return "no record found to delete";
	}
	@Override
	public VaccineRegistration getVaccineRegistration(long registrationId) {
		return vrrepo.getByRegistrationId(registrationId);
	}
	
	
	@Override
	public List<VaccineRegistration> getAllVaccineRegistrations() {
		return vrrepo.findAll();
	}
	@Override
	public List<Member> getAllMember(long mobileno) {
		List<Member> memList=new ArrayList<>();
		memList=vrrepo.getMemberList(mobileno);
		return memList;
	}

	public VaccineRegistration getByMobile(long mobileno)
	{
		return vrrepo.getByMobile(mobileno);
	}
}
