package com.company.springbootcrudbasic.service.impl;

import com.company.springbootcrudbasic.dto.PersonDto;

public class Validator {
	
	public static boolean validateId(Long id) {
		return id != null;
	}
	
	public static boolean validateFirstName(String firstName) {
		return firstName != null && !firstName.trim().isEmpty();
	}
	
	public static boolean validateLastName(String lastName) {
		return lastName != null && !lastName.trim().isEmpty();
	}
	
	public static boolean validateTypeId(String typeId) {
		return typeId != null && !typeId.trim().isEmpty();
	}
	
	public static boolean validateNumberId(int id) {
		return id != 0;
	}
	
	public static boolean validateTypePerson(String typePerson) {
		return typePerson != null && !typePerson.trim().isEmpty();
	}
	
	public static boolean validateCreateMandatoryFields(PersonDto personDto) {
		if (validateFirstName(personDto.getFirstName())
				|| validateLastName(personDto.getLastName())
				|| validateTypeId(personDto.getTypeIdentification())
				|| validateNumberId(personDto.getNumberIdentification())
				|| validateTypePerson(personDto.getTypePerson())) {
			return true;
		}
		return false;
	}
	
	public static boolean validateUpdateteMandatoryFields(PersonDto personDto) {
		if (validateId(personDto.getId()) 
				&& (validateFirstName(personDto.getFirstName())
					|| (personDto.getMiddleName() != null && !personDto.getMiddleName().trim().isEmpty())
					|| validateLastName(personDto.getLastName())
					|| validateTypeId(personDto.getTypeIdentification())
					|| validateNumberId(personDto.getNumberIdentification())
					|| validateTypePerson(personDto.getTypePerson()))) {
			return true;
		}
		return false;
	}

}
