dataSource {
    pooled = true
       driverClassName = "org.h2.Driver"
//	  driverClassName = "com.sybase.jdbc2.jdbc.SybDriver"
    username = "sa"
    password = ""
//	username = "aexa"
//	password = "ae256xa"
	logSql=true
	
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
//			  url = "jdbc:hsqldb:file:devDB"
//			  url = "jdbc:jtds:sybase://localhost:1234;DatabaseName=DB_UTFSM"
//			  url = "jdbc:sybase:Tds:localhost:1234/DB_UTFSM"
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
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
}
