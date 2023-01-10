package com.cg.eis.vaccination.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.eis.vaccination.entities.Appointment;

@Repository
@Transactional
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
	@Query(value="select app from Appointment app where app.bookingid=?1")
	public Appointment getAppointment(long bookingid);
	@Query(value="select a from Appointment a")
	public List<Appointment> getAllAppointment();
	@Modifying
	@Query(value="delete from Appointment a where a.bookingid=:id")
	public void deleteByid(@Param("id")  long bookingid);
}

