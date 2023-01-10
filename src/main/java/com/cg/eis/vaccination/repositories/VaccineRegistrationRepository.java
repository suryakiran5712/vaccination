package com.cg.eis.vaccination.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.eis.vaccination.entities.Member;
import com.cg.eis.vaccination.entities.VaccineRegistration;

@Repository
@Transactional
public interface VaccineRegistrationRepository extends JpaRepository<VaccineRegistration,Long>{

	@Query(value="select a from VaccineRegistration a where mobileno=?1")
	public VaccineRegistration getByMobile(long mobileno);
	@Query(value="select m.memberlist from VaccineRegistration m where m.mobileno=?1")
	public List<Member> getMemberList(long mobileno);
	@Query(value="delete VaccineRegistration  where mobileno=?1",nativeQuery = true)
	public String delete(long mobileNo);
	@Query(value="select a from VaccineRegistration a where a.registrationId=?1")
	public VaccineRegistration getByRegistrationId(long id);
	@Modifying
	@Query(value="delete from VaccineRegistration a where a.registrationId=:id")
	public void deleteByid(@Param("id")  long id);
}
