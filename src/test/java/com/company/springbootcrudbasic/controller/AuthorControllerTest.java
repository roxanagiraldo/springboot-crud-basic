package com.company.springbootcrudbasic.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.springbootcrudbasic.jook.controller.AuthorController;
import com.company.springbootcrudbasic.jook.service.AuthorService;
import com.company.springbootcrudbasic.jooq.model.tables.pojos.Author;

@RunWith(SpringJUnit4ClassRunner.class)
class AuthorControllerTest {
	
	@InjectMocks
	AuthorController authorController;
	
	@Mock
	AuthorService authorService;
	
	@Mock
	Author author;
	
	{
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void getAuthorsTest() {
		
		List<Author> authorList = new ArrayList<>();
		authorList.add(author);
		when(authorService.getAuthors()).thenReturn(authorList);
		assertEquals(authorController.getAuthors().size(), authorList.size());
	}

}
