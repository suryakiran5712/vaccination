package com.cg.eis.vaccination.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.eis.vaccination.entities.IdCard;

@Repository
public interface IdCardRepository extends JpaRepository<IdCard,Long>{
	@Query(value="select a from IdCard a where a.aadharNo=?1")
	public IdCard getAdharCardByNo(long aadharNo);
}
