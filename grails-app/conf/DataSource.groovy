dataSource {
    pooled = true
    //driverClassName = "org.h2.Driver"
    driverClassName = "org.postgresql.Driver"

    username = "postgres"
    password = "nostrom0"
    pooled = true
    dialect = org.hibernate.dialect.mydialect.PostgreSQL8Dialect
    validationQuery = "select 1 from dual"
    logSql = false


}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    //cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'

}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop" //create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:postgresql://localhost/mycloudmedia"
            //url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            pooled = true
            properties {
                maxActive = -1
                minEvictableIdleTimeMillis = 1800000
                timeBetweenEvictionRunsMillis = 1800000
                numTestsPerEvictionRun = 3
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = true
                validationQuery = "SELECT 1"
            }
        }
    }
}
