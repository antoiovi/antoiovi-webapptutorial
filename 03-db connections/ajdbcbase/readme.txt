Progetto base jsf per connessione a database senza JPA (Java Persistence Api).
Vi e' una pagina xhtml per mostrare il contenuto della tabella.

+ Comandi maven per compilare il programma :

++Ambiente Application Server

   mvn package

++Ambiente Servlet Container (Testato su Tomcat Apache Tomcat/9.0.12 e su Jetty 9.4)

  mvn package -P servletContainer

+Configurazione mysql

++Tomcat (9.0.12)

  ${CATALINA_HOME}/lib/mysql-connector-java-8.0.12.jar

++ Jetty (9.4)

  ${jetty_base}/lib/ext/commons-dbcp-1.4.jar
  ${jetty_base}/lib/ext/commons-pool-1.6.jar
  ${jetty_home}/lib/mysql-connector-java-8.0.12.jar


+CREAZIONE DATABASE
  ++Mysql

    create database antoiovi_tutorials;
    CREATE USER 'sa'@'localhost' IDENTIFIED BY 'sa';
    CREATE USER 'sa'@'%' IDENTIFIED BY 'sa';
    GRANT ALL ON antoiovi_tutorials.* TO 'sa'@'localhost';
    GRANT ALL ON antoiovi_tutorials.* TO 'sa'@'%';


        Verficare che nel file ajdbcbase/sql/build.xml
         il tag <pathelement..> sia  impostato con il path in cui si trova il driver JDBC
         (Nell esempio : /usr/share/java/mysql-connector-java-8.0.12.jar)
         Spostarsi nella directory del progetto ajdbcbase/sql

      $ ant mysql


    ++Postgresql

      CREATE ROLE sa;
      ALTER USER sa PASSWORD 'sa';
      alter role sa  with LOGIN ;
      CREATE DATABASE antoiovi;
      \c antoiovi ;
       CREATE SCHEMA tutorials;
       alter schema tutorials owner to sa;

          Verficare che nel file ajdbcbase/sql/build.xml
          il tag <pathelement..> sia  impostato con il path in cui si trova il driver JDBC
          (Nell esempio : /usr/share/java/postgresql-42.2.5.jar)
          Spostarsi nella directory del progetto ajdbcbase/sql
          Spostarsi nella directory del progetto ajdbcbase/sql

         $ ant postgre

         
