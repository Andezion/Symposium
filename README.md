# Symposium


## Content
* [General info](#general-info)
* [Demonstration](#demonstration)
* [Technologies](#technologies)
* [Features](#features)
* [Setup](#setup)

```
 :: Spring Boot ::                (v3.2.5)

2025-09-09T16:17:41.130+02:00  INFO 15400 --- [  restartedMain] o.example.SymposiumManagerApplication    : Starting SymposiumManagerApplication using Java 23.0.1 with PID 15400 (C:\Users\vdoro\IdeaProjects\Last\target\classes started by vdoro in C:\Users\vdoro\IdeaProjects\Last)
2025-09-09T16:17:41.135+02:00  INFO 15400 --- [  restartedMain] o.example.SymposiumManagerApplication    : No active profile set, falling back to 1 default profile: "default"
2025-09-09T16:17:41.250+02:00  INFO 15400 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2025-09-09T16:17:41.250+02:00  INFO 15400 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
2025-09-09T16:17:42.516+02:00  INFO 15400 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2025-09-09T16:17:42.590+02:00  INFO 15400 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 64 ms. Found 4 JPA repository interfaces.
2025-09-09T16:17:43.173+02:00  INFO 15400 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8082 (http)
2025-09-09T16:17:43.188+02:00  INFO 15400 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2025-09-09T16:17:43.189+02:00  INFO 15400 --- [  restartedMain] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.20]
2025-09-09T16:17:43.255+02:00  INFO 15400 --- [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2025-09-09T16:17:43.255+02:00  INFO 15400 --- [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2004 ms
2025-09-09T16:17:43.446+02:00  INFO 15400 --- [  restartedMain] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2025-09-09T16:17:43.507+02:00  INFO 15400 --- [  restartedMain] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 6.4.4.Final
2025-09-09T16:17:43.541+02:00  INFO 15400 --- [  restartedMain] o.h.c.internal.RegionFactoryInitiator    : HHH000026: Second-level cache disabled
2025-09-09T16:17:43.772+02:00  INFO 15400 --- [  restartedMain] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
2025-09-09T16:17:43.799+02:00  INFO 15400 --- [  restartedMain] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2025-09-09T16:17:43.969+02:00  INFO 15400 --- [  restartedMain] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection org.postgresql.jdbc.PgConnection@1a35ee29
2025-09-09T16:17:43.970+02:00  INFO 15400 --- [  restartedMain] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2025-09-09T16:17:45.236+02:00  INFO 15400 --- [  restartedMain] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
2025-09-09T16:17:45.331+02:00  INFO 15400 --- [  restartedMain] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2025-09-09T16:17:45.804+02:00  WARN 15400 --- [  restartedMain] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2025-09-09T16:17:46.215+02:00  INFO 15400 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2025-09-09T16:17:46.270+02:00  INFO 15400 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8082 (http) with context path ''
2025-09-09T16:17:46.278+02:00  INFO 15400 --- [  restartedMain] o.example.SymposiumManagerApplication    : Started SymposiumManagerApplication in 5.575 seconds (process running for 6.708)
2025-09-09T16:17:52.832+02:00  INFO 15400 --- [nio-8082-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2025-09-09T16:17:52.832+02:00  INFO 15400 --- [nio-8082-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2025-09-09T16:17:52.833+02:00  INFO 15400 --- [nio-8082-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
```
