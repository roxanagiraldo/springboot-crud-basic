package com.company.springbootcrudbasic.jook.service;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.springbootcrudbasic.jooq.model.Tables;
import com.company.springbootcrudbasic.jooq.model.tables.pojos.Author;

@Service
public class AuthorService {

	@Autowired
	private DSLContext dslContext;
	
	public void insertAuthor(Author author) {
		
		dslContext.insertInto(Tables.AUTHOR, Tables.AUTHOR.ID, Tables.AUTHOR.FIRST_NAME, Tables.AUTHOR.LAST_NAME)
			.values(author.getId(), author.getFirstName(), author.getLastName())
			.execute();		
	}
	
	public Author getAuthor(Integer idAuthor) {
		return (Author) dslContext.selectFrom(Tables.AUTHOR)
				.where(Tables.AUTHOR.ID.eq(idAuthor)).fetchOne().into(Author.class);
	}
	
	public void updateAuthor(Author author) {
		dslContext.update(Tables.AUTHOR)
			.set(Tables.AUTHOR.FIRST_NAME, author.getFirstName())
			.set(Tables.AUTHOR.LAST_NAME, author.getLastName())
			.where(Tables.AUTHOR.ID.eq(author.getId()))
			.execute();
	}
	
	public void deleteAuthor(Integer idAuthor) {
		dslContext.deleteFrom(Tables.AUTHOR)
			.where(Tables.AUTHOR.ID.eq(idAuthor))
			.execute();
	}
	
	public List<Author> getAuthors(){
		return dslContext.selectFrom(Tables.AUTHOR).fetchInto(Author.class);
	}
}
