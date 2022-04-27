package com.company.springbootcrudbasic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.springbootcrudbasic.dto.PersonDto;
import com.company.springbootcrudbasic.service.impl.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping("personList")
	public List<PersonDto> getPerson(){
		return personService.getPersonList();
	}	
	
	@GetMapping("personExists")
	public boolean personExists(@RequestParam Long id){
		return personService.personExists(id);
	}
	
	@GetMapping("person")
	public PersonDto getPerson(@RequestBody PersonDto person){
		return personService.getPerson(person);
	}
	
	@PostMapping("person")
	public PersonDto createPerson(@RequestBody PersonDto person){
		return personService.createPerson(person);
	}
	
	@PutMapping("person")
	public PersonDto updatePerson(@RequestBody PersonDto person){
		return personService.updatePerson(person);
	}
	
	@DeleteMapping("person/{id}")
	public void deletePerson(@PathVariable Long id){
		personService.deletePerson(id);
	}
}
