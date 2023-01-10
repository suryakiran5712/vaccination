package com.cg.eis.vaccination.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.eis.vaccination.dto.MemberDto;
import com.cg.eis.vaccination.entities.Member;
import com.cg.eis.vaccination.service.MemberService;
import com.cg.eis.vaccination.utils.MemberAlreadyExistException;
import com.cg.eis.vaccination.utils.MemberNotFoundException;
import com.cg.eis.vaccination.utils.NoMembersFoundException;
import com.cg.eis.vaccination.utils.VaccinationInvalidDetailsException;

@RestController
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberService memServ;
	@PostMapping
	public ResponseEntity<Member> addMember(@RequestBody MemberDto member)
	{
		
		Member mem1=memServ.getMemberById(member.getMemberId());
		if(mem1!=null)
			throw new MemberAlreadyExistException();
		Member mem=memServ.addMember(member);
		if(mem==null)
		{
			throw new VaccinationInvalidDetailsException();	
		}
		return new ResponseEntity<Member>(mem,HttpStatus.OK);
	}
@PutMapping
public ResponseEntity<Member> updateMember(@RequestBody MemberDto member)
{
	Member val=memServ.getMemberById(member.getMemberId());
	if(val==null)
		throw new MemberNotFoundException();
	Member mem=memServ.updateMember(member);
	if(mem==null)
	{
		throw new VaccinationInvalidDetailsException();
	}
	return new ResponseEntity<Member>(mem,HttpStatus.OK);
}

@DeleteMapping("/{memid}")
public ResponseEntity<String> deleteMemberById(@PathVariable long memid)
{
	String status=memServ.deleteMemberById(memid);
	return new ResponseEntity<String>(status,HttpStatus.OK);
}


@GetMapping
public ResponseEntity<List<Member>> getAllMember() 
{
	List<Member> list=memServ.getAllMember();
	if(list.isEmpty())
		throw new NoMembersFoundException();
	return new ResponseEntity<List<Member>>(list,HttpStatus.OK);
}

@GetMapping("/id/{number}")
public ResponseEntity<Member> getMemberById(@PathVariable long number)
{
	Member mem=memServ.getMemberById(number);
	if(mem==null)
		throw new MemberNotFoundException();
	return new ResponseEntity<Member>(mem,HttpStatus.OK);
}

}

