package com.cg.eis.vaccination.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VaccinationExceptionHandler {

	@ExceptionHandler(value=VaccineAlreadyExistException.class)
	public ResponseEntity<Object> exception(VaccineAlreadyExistException ex){
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=VaccineNotFoundException.class)
	public ResponseEntity<Object> exception(VaccineNotFoundException ex)
	{
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=NoRecordsFoundException.class)
	public ResponseEntity<Object> exception(NoRecordsFoundException ex)
	{
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=FillInventoryDetailsException .class)
	public ResponseEntity<Object> exception(FillInventoryDetailsException  ex)
	{
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=VaccinationCenterAlreadyExistException.class)
	public ResponseEntity<Object> exception(VaccinationCenterAlreadyExistException ex)
	{
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=VaccinationCenterNotFoundException.class)
	public ResponseEntity<Object> exception(VaccinationCenterNotFoundException ex)
	{
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=NoVaccinationCenterFoundException.class)
	public ResponseEntity<Object> exception(NoVaccinationCenterFoundException ex)
	{
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=CardAlreadyExistException.class)
	public ResponseEntity<Object> exception(CardAlreadyExistException ex)
	{
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=CardNotFoundException.class)
	public ResponseEntity<Object> exception(CardNotFoundException ex)
	{
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=MemberAlreadyExistException.class)
	public ResponseEntity<Object> exception(MemberAlreadyExistException ex)
	{
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=MemberNotFoundException.class)
	public ResponseEntity<Object> exception(MemberNotFoundException ex)
	{
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=NoMembersFoundException.class)
	public ResponseEntity<Object> exception(NoMembersFoundException ex)
	{
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=VaccineInventoryAlreadyExists.class)
	public ResponseEntity<Object> exception(VaccineInventoryAlreadyExists ex)
	{
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=VaccineInventoryNotFoundException.class)
	public ResponseEntity<Object> exception(VaccineInventoryNotFoundException ex)
	{
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=VaccineRegAlreadyExistException.class)
	public ResponseEntity<Object> exception(VaccineRegAlreadyExistException ex)
	{
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=VaccineRegNotFoundException.class)
	public ResponseEntity<Object> exception(VaccineRegNotFoundException ex)
	{
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=AppAlreadyExistException.class)
	public ResponseEntity<Object> exception(AppAlreadyExistException ex)
	{
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=AppNotFoundException.class)
	public ResponseEntity<Object> exception(AppNotFoundException ex)
	{
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=VaccinationInvalidDetailsException.class)
	public ResponseEntity<Object> exception(VaccinationInvalidDetailsException ex)
	{
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
}
