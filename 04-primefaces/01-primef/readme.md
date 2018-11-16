#PRIMEF
Applicazione base di configurazione primefaces.
Contiene alcuni pagine per mostarer l'uso dei componenti piu frequenti di primefaces

## Compilazione
#### Per Application server
``` bash
mvn package
```
#### Per Servlet container (Jetty )

``` bash
mvn package -P servletContainer
```

### per eseguire il test velocemente
``` bash
mvn jetty:run
```

Icons :

ui-icon ui-icon-home

Attivare fa icons (https://www.primefaces.org/showcase/ui/misc/fa.xhtml)
  nel file web.xml mettere
         <context-param>
            <param-name>primefaces.FONT_AWESOME</param-name>
            <param-value>true</param-value>
         </context-param>
