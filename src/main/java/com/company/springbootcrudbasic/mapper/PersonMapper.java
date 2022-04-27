package com.company.springbootcrudbasic.mapper;

import com.company.springbootcrudbasic.dto.PersonDto;
import com.company.springbootcrudbasic.model.Person;

public class PersonMapper {
	
	public static Person personDtoToEntity(PersonDto personDto) {
		Person person = new Person(personDto.getId(), personDto.getFirstName(), personDto.getMiddleName(), personDto.getLastName(), 
				personDto.getTypeIdentification(), personDto.getNumberIdentification(), personDto.getTypePerson());		
		return person;
	}
	
	public static PersonDto personEntityToDto(Person person) {
		PersonDto personDto = new PersonDto(person.getId(), person.getFirstName(), person.getMiddleName(), person.getLastName(), 
				person.getTypeIdentification(), person.getNumberIdentification(), person.getTypePerson());
		return personDto;
	}

}
