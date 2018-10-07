# webapptutorial
Tutorial about web application with java tecnologies (jsf, jee, jpa)

Lista di progetti a cui si fa rifermenti nel blog da me tenuto ;

# 01-base
## 01base
Progetto base creato con il comando
```sh
  mvn archetype:generate -DarchetypeCatalog=internal
  10: internal -> org.apache.maven.archetypes:maven-archetype-webapp (An archetype which contains a sample Maven Webapp project.)
```
## 02base
 Al progetto sopra viene aggiunto un semplice backing bean e dei tag al file jsp

# 02-jsf

## a1jsf

	Progetto minimale con utilizzo di un ManagedBean e di due semplici pagine xhtml

## b1botstr

  Progetto minimale con configurazione per JSF e BootsFaces.
   Nel file web.xml sono sotto commento le dependency per application server, e
   sono attive le dependency per semplici servlet container.


# 03-db connections
## ajdbcbase

  Progetto base jsf per connessione a database senza JPA.
  Serve solo per mostrare le modalita' di utilizzo ai database, senza essere
   ottimizzato.

  Nella cartella sql sono presenti due file sql per la creazione di una tabella
  e per il popolamento con dati. 'E possibile caricare i dati usando ant da riga
   di comando, in quanto c'e' il file build.xml. Bisogna solo modificare alcune
   configurazioni in base al database e a dove e' collocato il drive JDBC.

   Sono realizzati tre classi java :
   1 una classe wrapper per la tabella persone
   2 una classe DAO minimale (modificare le variabili per il collegamento
      al database)
   3 Un backing bean per il collegamento

   Vi e' una pagina xhtml per mostrare il contenuto della tabella.
