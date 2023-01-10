package com.cg.eis.vaccination.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.eis.vaccination.entities.Vaccine;
@Transactional
@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {

	@Query(value="select v from Vaccine v where v.vaccineName=?1")
	public Vaccine getVaccineByName(String vaccinName);
	
	@Query(value="select v from Vaccine v where v.vaccineId=?1")
	public Vaccine getVaccineById(int vaccineId) ;
	
	@Modifying
	@Query(value="delete from Vaccine a where a.vaccineId=:id")
	public void deleteByid(@Param("id")  int id);

}
