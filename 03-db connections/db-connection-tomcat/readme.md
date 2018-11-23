
CREAZIONE database


mysql> create database antoiovi_tutorials;
mysql> CREATE USER 'sa'@'localhost' IDENTIFIED BY 'sa';
mysql> CREATE USER 'sa'@'%' IDENTIFIED BY 'sa';
mysql> GRANT ALL ON antoiovi_tutorials.* TO 'sa'@'localhost';
mysql> GRANT ALL ON antoiovi_tutorials.* TO 'sa'@'%';

DROP  TABLE IF  EXISTS persone;
CREATE TABLE IF NOT EXISTS persone (
    persona_id INT AUTO_INCREMENT,
    username VARCHAR(10) NOT NULL,
    nome VARCHAR(10) NOT NULL,
    cognome VARCHAR(10) NOT NULL,
    email VARCHAR(40) ,
    password VARCHAR(256) ,
    UNIQUE (username),
    PRIMARY KEY (persona_id)
)  ENGINE=INNODB;

INSERT INTO `persone`(username,nome,cognome,email,password) VALUES ("ant01","Antos","Bellis","antp@ader.it","password1");
INSERT INTO `persone`(username,nome,cognome,email,password) VALUES ("ant02","Antoss","Belliss","anntp@ader.it","password2");



JETTY MVN plugin

    mvn clean jetty:run

    La porta è configurata : 	<port>8888</port>
    Il classpath :  <contextPath>/abc</contextPath>
    la applicazione si trova in 127.0.0.1:8888/abc


SERVLET CONTAINER  (TOMCAT o Jetty)

1 Compilare :
  mvn clean package -P servletContainer

2 Copiare il file war nella directory di deploy :
  TOMCAT
   cp target/ajdbcbase2.war /home/antoiovi/apache-tomcat-9.0.12/webapps/

 Oppure in JETTY :
   cp target/ajdbcbase2.war $jetty_base/webapps/

 APPLICATION SERVER (JBOSS)

  1 Compilare
    mvn clean package

  2 Copiare il file war nella directory di deploy :

    cp target/ajdbcbase2.war {EAP_HOME}/standalone/deployments/

Configurazione database e jndi:
TOMCAT
Verifichiamo che sia presente il JDBC Driver nella directory tomcat_insyallation_path/lib.
 Se non presente copiamo il file jar (nel nostro esempio mysql-connector-java-8.0.12.jar).
Aggiungere il seguente codice nel file $CATALINA_HOME/conf/context.xml :
<Context>
.......
 <!-- Aggiunto database   -->
  <Resource name="jdbc/mysqlantoioviDB" auth="Container" type="javax.sql.DataSource"
              maxTotal="100" maxIdle="30" maxWaitMillis="10000"
              username="sa" password="sa" driverClassName="com.mysql.jdbc.Driver"
              url="jdbc:mysql://localhost:3306/antoiovi_tutorials?&amp;serverTimezone=UTC"/>

</Context>



JETTY
Configurazione server
 creo una directory di lavoro separata dal server chiamata nome_mia_base
  mi sposto in essa e la inizzializzo

  mkdir nome_mia_base
  cd nome_mia_base

  Consideriamo di essere in una directory sottostante la directory jetty_home, quindi utilizzo nei comandi successivi il comando ../start.jar

            in altri casi  posso semplicemente configurare $JETTY_HOME ed usare $JETTY_HOME/start.jar

            crea directory start.d

            java -jar ../start.jar --create-startd

             Creazione directory web apps e inizzializzazione deploy
java -jar ../start.jar --add-to-start=deploy

 Moduli indispensabili per usare jsf
java -jar ../start.jar --add-to-start=jsp,jstl,http

 Modulo indispensabile per cercare le librerie nelle directory  ${jetty.base}lib e  ${jetty.base}lib/ext
java -jar ../start.jar --add-to-start=ext

 Moduli indispensabili per usare "org.eclipse.jetty.plus.jndi.Resource" (Configurazione Datasource)

$ java -jar ../start.jar --add-to-start=plus


  ${jetty_base}/lib/ext/commons-dbcp-1.4.jar
  ${jetty_base}/lib/ext/commons-pool-1.6.jar

Configurazione database

Creare File $JETTY_BASE/web/nomefile.xml:

<?xml version="1.0"?>
<!DOCTYPE Configure PUBLIC "-//Mort Bay Consulting//DTD Configure//EN" "http://www.eclipse.org/jetty/configure_9_3.dtd">
<Configure id='wac' class="org.eclipse.jetty.webapp.WebAppContext">
 <Set name="contextPath">/ajdbcbase</Set>
 <Set name="war"><Property name="jetty.webapps" default="."/>/ajdbcbase.war</Set>
 <Set name="extractWAR">true</Set>
 <Set name="copyWebDir">false</Set>
<Set name="configurationDiscovered">true</Set>

    <New id="myDS" class="org.eclipse.jetty.plus.jndi.Resource">
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
