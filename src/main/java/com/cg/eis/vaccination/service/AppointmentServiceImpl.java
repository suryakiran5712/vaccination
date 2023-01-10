package com.cg.eis.vaccination.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.eis.vaccination.dto.AppointmentDto;
import com.cg.eis.vaccination.entities.Appointment;
import com.cg.eis.vaccination.entities.Member;
import com.cg.eis.vaccination.entities.VaccinationCenter;
import com.cg.eis.vaccination.repositories.AppointmentRepository;
import com.cg.eis.vaccination.repositories.MemberRepository;
import com.cg.eis.vaccination.repositories.VaccinationCenterRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	@Autowired
	AppointmentRepository apRepo;
	@Autowired
	VaccinationCenterRepository vcRepo;
	@Autowired
	MemberRepository memRepo;
	@Override
	public Appointment addAppointment(AppointmentDto appDto) {
		Member mem=memRepo.getMemberById(appDto.getMemberId());
		VaccinationCenter vc=vcRepo.getByCenterId(appDto.getCenterCode());
		if(mem==null || vc==null)
		{
			return null;
		}
		Appointment ap=new Appointment(appDto.getBookingId(),appDto.getMobileno(),mem,vc,appDto.getDateofbooking(),appDto.getSlot(),appDto.getBookingStatus());
		return apRepo.save(ap);	 
	}
	@Override
	public Appointment updateAppointment(AppointmentDto appDto) {
		if(apRepo.existsById(appDto.getBookingId()))
		{
			Member mem=memRepo.getMemberById(appDto.getMemberId());
			VaccinationCenter vc=vcRepo.getByCenterId(appDto.getCenterCode());
			if(mem==null || vc==null)
			{
				return null;
			}
			Appointment ap=new Appointment(appDto.getBookingId(),appDto.getMobileno(),mem,vc,appDto.getDateofbooking(),appDto.getSlot(),appDto.getBookingStatus());
			return apRepo.save(ap); 
		}
		return null;
	}
	@Override
	public String deleteAppointment(long bookingid) {
		if(apRepo.existsById(bookingid))
		{
			apRepo.deleteByid(bookingid);
			return "delete succecssful";
		}
		return "delete failed";
	}
	@Override
	public Appointment getAppointment(long bookingid) {
		return apRepo.getAppointment(bookingid); 
	}
	@Override
	public List<Appointment> getAllAppointment() {
		return apRepo.getAllAppointment();
	}
}
