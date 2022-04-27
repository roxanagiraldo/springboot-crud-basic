package com.company.springbootcrudbasic.jook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.springbootcrudbasic.jook.service.AuthorService;
import com.company.springbootcrudbasic.jooq.model.tables.pojos.Author;

@RequestMapping("/authors")
@RestController
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@PostMapping
	public String addAuthor(@RequestBody Author author) {
		authorService.insertAuthor(author);
		return "Author added.";
	}
	
	@GetMapping
	public List<Author> getAuthors(){
		return authorService.getAuthors();
	}

}
