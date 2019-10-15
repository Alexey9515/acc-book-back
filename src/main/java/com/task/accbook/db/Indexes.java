/*
 * This file is generated by jOOQ.
 */
package com.task.accbook.db;


import com.task.accbook.db.tables.Databasechangeloglock;
import com.task.accbook.db.tables.Salaries;
import com.task.accbook.db.tables.Users;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index DATABASECHANGELOGLOCK_PKEY = Indexes0.DATABASECHANGELOGLOCK_PKEY;
    public static final Index SALARIES_PK = Indexes0.SALARIES_PK;
    public static final Index SALARIES_USER_ID_KEY = Indexes0.SALARIES_USER_ID_KEY;
    public static final Index USERS_NAME_KEY = Indexes0.USERS_NAME_KEY;
    public static final Index USERS_PK = Indexes0.USERS_PK;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index DATABASECHANGELOGLOCK_PKEY = Internal.createIndex("databasechangeloglock_pkey", Databasechangeloglock.DATABASECHANGELOGLOCK, new OrderField[] { Databasechangeloglock.DATABASECHANGELOGLOCK.ID }, true);
        public static Index SALARIES_PK = Internal.createIndex("salaries_pk", Salaries.SALARIES, new OrderField[] { Salaries.SALARIES.ID }, true);
        public static Index SALARIES_USER_ID_KEY = Internal.createIndex("salaries_user_id_key", Salaries.SALARIES, new OrderField[] { Salaries.SALARIES.USER_ID }, true);
        public static Index USERS_NAME_KEY = Internal.createIndex("users_name_key", Users.USERS, new OrderField[] { Users.USERS.NAME }, true);
        public static Index USERS_PK = Internal.createIndex("users_pk", Users.USERS, new OrderField[] { Users.USERS.ID }, true);
    }
}
