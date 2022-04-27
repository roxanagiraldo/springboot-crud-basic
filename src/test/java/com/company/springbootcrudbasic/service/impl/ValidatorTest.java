package com.company.springbootcrudbasic.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidatorTest {

	@Test
	void validateIdTest() {
		assertTrue(Validator.validateId(1L));
	}
	
	@Test
	void validateNullIdTest() {
		assertFalse(Validator.validateId(null));
	}

}
