package com.cg.eis.vaccination.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.eis.vaccination.entities.Member;

@Repository
@Transactional
public interface MemberRepository extends JpaRepository<Member, Long>{

	@Query(value = "select m from Member m where m.memberId=?1")
	public Member getMemberById(long memberId);
	
	@Query(value="select * from Member m left outer join IdCard ic on m.aadharNo=ic.aadharNo where ic.aadharNo=?1",nativeQuery = true)
	public Member getMemberByAadharNo(long adharno);

	@Query(value= "select member_id from member where aadhar_no=?1",nativeQuery = true)
	public long getIdbyAdhar(long adharno);
	@Modifying
	@Query(value="delete from Member a where a.memberId=:id")
	public void deleteByid(@Param("id")  long bookingid);
}
