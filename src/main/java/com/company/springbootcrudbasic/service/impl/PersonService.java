package com.company.springbootcrudbasic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.company.springbootcrudbasic.dto.PersonDto;
import com.company.springbootcrudbasic.mapper.PersonMapper;
import com.company.springbootcrudbasic.model.Person;
import com.company.springbootcrudbasic.model.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;
	
	public List<PersonDto> getPersonList(){
		List<Person> personList = ((List<Person>) personRepository.findAll());
		return personList.stream().map(s -> PersonMapper.personEntityToDto(s)).toList();
	}
	
	public boolean personExists(Long id){
		return personRepository.existsById(id);
	}
	
	public PersonDto getPerson(PersonDto personDto){
		if (personDto != null && Validator.validateId(personDto.getId())) {
			return PersonMapper.personEntityToDto(personRepository.findById(personDto.getId()).get());
		} 
		throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
	}
	
	public PersonDto createPerson(PersonDto personDto){
		if (Validator.validateCreateMandatoryFields(personDto)) {
			return PersonMapper.personEntityToDto(personRepository.save(PersonMapper.personDtoToEntity(personDto)));
		} 
		throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
	}
	
	public PersonDto updatePerson(PersonDto personDto){
		if (Validator.validateUpdateteMandatoryFields(personDto)) {
			if (personRepository.findById(personDto.getId()).isPresent()) {
				return PersonMapper.personEntityToDto(personRepository.save(PersonMapper.personDtoToEntity(personDto)));
			} else {
				throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
			}
		} else {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		}
	}
	
	public void deletePerson(Long personId){
		personRepository.deleteById(personId);
	}
}
