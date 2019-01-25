# Project structure

This template project uses Boundary Control Entity (BCE) pattern. Very good description of this pattern is presented by Adam Bien - [Structuring Java EE 7 Applications](https://www.youtube.com/watch?v=grJC6RFiB58).

Struttura base con due Entities : User e Roles


Pagina base con lista utenti
Pagina per inserire un nuovo utente 

Il file persitence.xml no è collegato al database, in quanto viene eseguito tramite 
il maven tomee plugin e quindi le configurazioni sono nella directory  src/test/tomee/conf/system.properties





# Configuring RDBMS

This template project uses HSQLDB. If you want to use other RDBMS:
* add JDBC driver into libs/lib element of tomee-maven-plugin configuration in pom.xml;
* edit DataSource configuration in src/test/tomee/conf/system.properties

# Running HSQLDB instance

```mvn exec:java```

# Running the project

```mvn package tomee:start```

# Shutting down the project

```mvn tomee:stop```
