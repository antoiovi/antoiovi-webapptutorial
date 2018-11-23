
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




TOMCAT
1 Compilare :
  mvn clean package -P servletContainer

2 Copiare il file war nella directory di deploy :
  TOMCAT
   cp target/ajdbcbase2.war /home/antoiovi/apache-tomcat-9.0.12/webapps/

Configurazione database e jndi:

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

 
