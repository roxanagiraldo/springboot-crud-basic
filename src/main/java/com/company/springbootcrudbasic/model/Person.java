package com.company.springbootcrudbasic.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Builder;

@Builder(toBuilder = true)
@XmlRootElement
@Entity
public class Person {
	
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String typeIdentification;
	private int numberIdentification;
	private String typePerson;
	
	public Person() {
		super();
	}
	
	public Person(Long id, String firstName, String middleName, String lastName, String typeIdentification,
			int numberIdentification, String typePerson) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.typeIdentification = typeIdentification;
		this.numberIdentification = numberIdentification;
		this.typePerson = typePerson;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTypeIdentification() {
		return typeIdentification;
	}
	public void setTypeIdentification(String typeIdentification) {
		this.typeIdentification = typeIdentification;
	}
	public int getNumberIdentification() {
		return numberIdentification;
	}
	public void setNumberIdentification(int numberIdentification) {
		this.numberIdentification = numberIdentification;
	}
	public String getTypePerson() {
		return typePerson;
	}
	public void setTypePerson(String typePerson) {
		this.typePerson = typePerson;
	}
}
