/*
 * This file is generated by jOOQ.
 */
package com.company.springbootcrudbasic.jooq.model;


import com.company.springbootcrudbasic.jooq.model.tables.Author;
import com.company.springbootcrudbasic.jooq.model.tables.records.AuthorRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in 
 * springboot_test.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AuthorRecord> KEY_AUTHOR_PRIMARY = Internal.createUniqueKey(Author.AUTHOR, DSL.name("KEY_author_PRIMARY"), new TableField[] { Author.AUTHOR.ID }, true);
}