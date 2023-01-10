package com.cg.eis.vaccination.service;

import java.util.List;

import com.cg.eis.vaccination.dto.MemberDto;
import com.cg.eis.vaccination.entities.Member;

public interface MemberService {

	public Member addMember(MemberDto member);
	public Member updateMember(MemberDto member);
	public String deleteMemberById(long id);
	public Member getMemberById (long idcardid);
	public Member getMemberByAdharNo(long adharno);
	public List<Member> getAllMember();
}

