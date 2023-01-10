package com.cg.eis.vaccination.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.eis.vaccination.dto.MemberDto;
import com.cg.eis.vaccination.entities.IdCard;
import com.cg.eis.vaccination.entities.Member;
import com.cg.eis.vaccination.entities.Vaccine;
import com.cg.eis.vaccination.entities.VaccineRegistration;
import com.cg.eis.vaccination.repositories.IdCardRepository;
import com.cg.eis.vaccination.repositories.MemberRepository;
import com.cg.eis.vaccination.repositories.VaccineRegistrationRepository;
import com.cg.eis.vaccination.repositories.VaccineRepository;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberRepository memRepo;
	@Autowired
	VaccineRepository vacRepo;
	@Autowired
	IdCardRepository aaRepo;
	@Autowired
	VaccineRegistrationRepository vrRepo;
	@Override
	public Member addMember(MemberDto memDto) {
		Vaccine vaccine=vacRepo.getVaccineById(memDto.getVaccineId());
		IdCard aCard=aaRepo.getAdharCardByNo(memDto.getAadharNo());
		VaccineRegistration vr=vrRepo.getByRegistrationId(memDto.getVaccineRegistrationId());
		if(vr==null || vaccine==null || aCard==null)
		{
			return null;
		}
		Member mem1=new Member(memDto.getMemberId(),aCard,memDto.getDose1status(),
				memDto.getDose2status(),memDto.getDose1date(),memDto.getDose2date(),
				vaccine);
		vr.getMemberlist().add(mem1);
		vrRepo.save(vr);
		return memRepo.save(mem1);
	}	
	@Override
	public Member updateMember(MemberDto member) {
		
		Vaccine vaccine=vacRepo.getVaccineById(member.getVaccineId());
		if(vaccine!=null)
		{
		IdCard aCard=aaRepo.getAdharCardByNo(member.getAadharNo());
		Member mem1=new Member(member.getMemberId(),aCard,member.getDose1status(),
				member.getDose2status(),member.getDose1date(),member.getDose2date(),
				vaccine);
		
		return memRepo.save(mem1);
			
		}
		return null;
	}
	@Override
	public String deleteMemberById(long id) {
		if(memRepo.existsById(id))
		{
			try {
			memRepo.deleteByid(id);
			return "delete successful";
			}
			catch(Exception e)
			{
				return "delete all dependencies and try again";
			}
			
		}
		return "delete failed";
	}	
	@Override
	public Member getMemberByAdharNo(long adharno) {
		return memRepo.getMemberByAadharNo(adharno);
		
	}
	@Override
	public Member getMemberById(long memberId) {
		return memRepo.getMemberById(memberId);
	}

	@Override
	public List<Member> getAllMember() {
		return memRepo.findAll();
	}

}
