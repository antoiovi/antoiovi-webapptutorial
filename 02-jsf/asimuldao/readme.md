# asimuldao

Programma base che ha un simulatore di databaes implementando un dao (PersonDao)
tramite List e ArrayList.
Da usare come base per programmi di test senza la necessita di creare
collegamenti a database

To be used as bases to test programs , whithout the need to build a databse
connection.



The program is composed of a bean (Person.java) , a class tha simulate a database,
which instead of connecting to a Database , implements a List of Persons with an
ArrayList (PersonDao.java) and a backing bean to link data to jsf pages (Personbean.java)

The  program can be used to test JSF functionalities without the need to
configure database connections.

There are furthermore two JSF pages : one with a table tha show all the persons,
and one with a form to input new entities (Persons).

The properties of the  Person bean class are annotated with javax.validaton Annotations.



# Compiling and Running

## Jetty maven plugin

  mvn jetty:run

go to http:// localhost:8888/abc/antoioviDB

## Tomcat

  mvn clean package -P servletContainer

go to http:// localhost:8080/antoioviDB

## Wildfly / TomEE

    mvn clean package

go to http:// localhost:8080/antoioviDB


*Author Antonello Iovino antoiovi*
