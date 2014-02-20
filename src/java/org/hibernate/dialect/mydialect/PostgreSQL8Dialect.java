package org.hibernate.dialect.mydialect;


import org.hibernate.dialect.PostgreSQLDialect;

import java.sql.Types;

public class PostgreSQL8Dialect extends PostgreSQLDialect {

    public PostgreSQL8Dialect() {
        super();
        registerColumnType(Types.BIGINT, "serial");
        // and maybe some more...
    }
}