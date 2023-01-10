package com.cg.eis.vaccination.repositories;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.eis.vaccination.entities.VaccineInventory;

@Repository
@Transactional
public interface VaccineInventoryRepository extends JpaRepository<VaccineInventory, Long>{
	@Query(value="select * from VaccineInventory m left outer join VaccinationCenter ic on m.center_code=ic.code where ic.code=?1",nativeQuery = true)
	public VaccineInventory getVaccineInventoryByCenter(long centerid);
	@Query(value="select v from VaccineInventory v where v.vaccinedate=?1")
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate date);
	@Query(value="select v from VaccineInventory v")
	public List<VaccineInventory> getAllVaccineInventory();
	@Query(value="select V from VaccineInventory V where V.vaccineInventoryId=?1")
	public VaccineInventory getById(long Id);
	@Modifying
	@Query(value = "delete from VaccineInventory v where v.vaccineInventoryId=:id")
	public void deleteByid(@Param("id") long id);
}
