package com.company.springbootcrudbasic.jook.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.jooq.SelectWhereStep;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Fields;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.springbootcrudbasic.jooq.model.Tables;
import com.company.springbootcrudbasic.jooq.model.tables.pojos.Author;
import com.company.springbootcrudbasic.jooq.model.tables.records.AuthorRecord;

@RunWith(SpringJUnit4ClassRunner.class)
class AuthorServiceTest {

	@InjectMocks
	AuthorService authorService;
	
	@Mock
	DSLContext dslContext;
	
	@Mock
	SelectWhereStep<AuthorRecord> selectAuthorRecord;
	
	@Mock
	SelectConditionStep<AuthorRecord> selectConditionAuthor;
	
	@Mock
	AuthorRecord authorRecord;
	
	@Mock
	Author author;
	
	@Mock
	Fields fields;
	
	private static final int ID = 1;
	
	{
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void getAuthorTest() {
		//authorService.getAuthor(ID);
		//authorRecord = new AuthorRecord();
		//authorRecord.
		when(dslContext.selectFrom(Tables.AUTHOR)).thenReturn(selectAuthorRecord);
		when(selectAuthorRecord.where(Tables.AUTHOR.ID.eq(ID))).thenReturn(selectConditionAuthor);
		when(selectConditionAuthor.fetchOne()).thenReturn(authorRecord);
		when(authorRecord.into(Mockito.any(Object.class))).thenReturn(author);
		
		/*when(dslContext.selectFrom(Tables.AUTHOR)
				.where(Tables.AUTHOR.ID.eq(ID))).thenReturn(selectConditionAuthor);
		when(selectConditionAuthor.fetchOne().into(Author.class)).thenReturn(author);*/
		assertNotNull(authorService.getAuthor(ID));
	}

}
