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

  aggiungere il segunet codice nel file  TomcatInstallationPath/conf/context.xml :
  <!-- Aggiunto database di test mysql  -->
 <Resource name="jdbc/mysqlantoioviDB" auth="Container" type="javax.sql.DataSource"
             maxTotal="100" maxIdle="30" maxWaitMillis="10000"
             username="sa" password="sa" driverClassName="com.mysql.jdbc.Driver"
             url="jdbc:mysql://localhost:3306/antoiovi_tutorials?&amp;serverTimezone=UTC"/>
</Context>

++ Jetty (9.4)

  ${jetty_base}/lib/ext/commons-dbcp-1.4.jar
  ${jetty_base}/lib/ext/commons-pool-1.6.jar
  ${jetty_home}/lib/mysql-connector-java-8.0.12.jar


Creare il file $JETTY_BASE/web/nomefile.xml:
  <?xml version="1.0"?>
  <!DOCTYPE Configure PUBLIC "-//Mort Bay Consulting//DTD Configure//EN" "http://www.eclipse.org/jetty/configure_9_3.dtd">
  <Configure id='wac' class="org.eclipse.jetty.webapp.WebAppContext">
    <Set name="contextPath">/ajdbcbase</Set>
    <Set name="war"><Property name="jetty.webapps" default="."/>/ajdbcbase.war</Set>
    <Set name="extractWAR">true</Set>
    <Set name="copyWebDir">false</Set>
   <Set name="configurationDiscovered">true</Set>

       <New id="mysqlantoioviDB" class="org.eclipse.jetty.plus.jndi.Resource">
            <Arg></Arg>
            <Arg>jdbc/myDS</Arg>
            <Arg>
                <New class="org.apache.commons.dbcp.BasicDataSource">
                   <Set name="driverClassName">com.mysql.jdbc.Driver</Set>
                   <Set name="url">jdbc:mysql://localhost:3306/antoiovi_tutorials?&amp;serverTimezone=UTC</Set>
                   <Set name="username">sa</Set>
                   <Set name="password">sa</Set>
                </New>
            </Arg>
           </New>
  </Configure>

  oppure aggiungere il seguente codice nel file $JETTY_HOME/etc/jetty.xml:
  <New id="jdbc/mysqlantoioviDB" class="org.eclipse.jetty.plus.jndi.Resource">
          <Arg></Arg>
          <Arg>jdbc/mysqlantoioviDB</Arg>
          <Arg>
              <New class="org.apache.commons.dbcp.BasicDataSource">
                 <Set name="driverClassName">com.mysql.jdbc.Driver</Set>
                 <Set name="url">jdbc:mysql://localhost:3306/antoiovi_tutorials?&amp;serverTimezone=UTC</Set>
                 <Set name="username">sa</Set>
                 <Set name="password">sa</Set>
              </New>
          </Arg>
         </New>

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
