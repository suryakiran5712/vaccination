package com.cg.eis.vaccination.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.eis.vaccination.entities.VaccinationCenter;

@Repository
@Transactional
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter,Integer>{

	@Query(value="select v from VaccinationCenter v where code=?1")
	public VaccinationCenter getByCenterId(int centerid);
	
	@Modifying
	@Query(value="delete from VaccinationCenter a where a.code=:id")
	public void deleteByid(@Param("id")  int id);
}
