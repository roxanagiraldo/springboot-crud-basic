package com.company.springbootcrudbasic.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.company.springbootcrudbasic.dto.PersonDto;
import com.company.springbootcrudbasic.model.Person;
import com.company.springbootcrudbasic.model.PersonRepository;

class PersonServiceTest {
	
	private final long PERSON_ID = 1L;
	
	@InjectMocks
	PersonService personService;
	
	@Mock
	PersonRepository personRepository;
	
	@Mock
	Person person;
	
	@Mock
	PersonDto personDto;
	
	{
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void getPersonListTest() {		
		personService.getPersonList();
		verify(personRepository).findAll();	
	}
	
	@Test
	void getPersonTest() {
		Optional<Person> opPer = Optional.of(person);
		when(personRepository.findById(Mockito.anyLong())).thenReturn(opPer);
		personDto.setId(PERSON_ID);
		PersonDto personResult =  personService.getPerson(personDto);
		assertNotNull(personResult);
	}
	
	@Test
	void updatePersonTest() {
		PersonDto per = new PersonDto();
		per.setId(PERSON_ID);
		per.setFirstName("NameToUpdate");
		person.setId(PERSON_ID);
		Optional<Person> opPer = Optional.of(person);
		when(personRepository.findById(Mockito.anyLong())).thenReturn(opPer);
		personService.updatePerson(per);
		verify(personService).updatePerson(per);	
	}
	
	@Test
	void deletePersonTest() {		
		personService.deletePerson(PERSON_ID);
		verify(personRepository).deleteById(PERSON_ID);	
	}

}
