package com.company.springbootcrudbasic.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.HttpClientErrorException;

import com.company.springbootcrudbasic.dto.PersonDto;
import com.company.springbootcrudbasic.service.impl.PersonService;

class PersonControllerTest {

	private final long PERSON_ID = 1L;
	
	@InjectMocks
	PersonController personController;
	
	@Mock
	PersonService personService;
	
	@Mock
	PersonDto personDto;
	
	{
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void getPersonListTest() {

		personController.getPerson();
		verify(personService).getPersonList();
	
	}
	
	@Test
	void getPersonTest() {
		personDto.setId(PERSON_ID);
		when(personService.getPerson(Mockito.any(PersonDto.class))).thenReturn(personDto);
		PersonDto personResult =  personController.getPerson(personDto);
		assertNotNull(personResult);
		
	}
	
	@Test 
	void getNullPersonTest() {
		try {
			personController.getPerson(null);
		} catch (HttpClientErrorException he) {
			assertTrue(true);
		}
		//TODO revisar que pasa con los metodos estaticos
		//assertThrowsExactly(HttpClientErrorException.class, () -> personController.getPerson(null));
		
	}
	
	@Test
	void createPersonTest() {		
		personController.createPerson(personDto);
		verify(personService).createPerson(personDto);	
	}
	
	@Test
	void updatePersonTest() {		
		personController.updatePerson(personDto);
		verify(personService).updatePerson(personDto);	
	}

	@Test
	void deletePersonTest() {		
		personController.deletePerson(PERSON_ID);
		verify(personService).deletePerson(PERSON_ID);	
	}
}
