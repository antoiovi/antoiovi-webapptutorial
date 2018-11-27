# Program to verify funzionality of javax.validation api

The program is composed of a bean (Person.java) , a class tha simulate a database,
which instead of connecting to a Database , implements a List of Persons with an
ArrayList (PersonDao.java) and a backing bean to link data to jsf pages (Personbean.java)

The  program can be used to test JSF functionalities without the need to
configure database connections.

There are furthermore two JSF pages : one with a table tha show all the persons,
and one with a form to input new entities (Persons).

The properties of the  Person bean class are annotated with javax.validaton Annotations.

## Problems
At the beginning the program gave these problems :

* Running with Wildfly  the validation process works properly;
* Running with TomEE the validation process works,  excpet for @Email annotation.
* Running with Tomcat and Jetty the annotations (@Size,@Email , etc) does not have any effect.


## Soulution of problems
The problems were solved adding the dependencies

```XML
<dependency>
  <groupId>org.hibernate.validator</groupId>
  <artifactId>hibernate-validator</artifactId>
  <version>6.0.13.Final</version>
</dependency>
<!--Mandatory for not JavaEE servers like Tomcat or Jetty   -->
<dependency>
    <groupId>javax.el</groupId>
    <artifactId>javax.el-api</artifactId>
    <version>3.0.0</version>
</dependency>
<dependency>
  <groupId>org.glassfish.web</groupId>
    <artifactId>javax.el</artifactId>
    <version>2.2.6</version>
  </dependency>

```


# Compiling and Running

## Jetty maven plugin
