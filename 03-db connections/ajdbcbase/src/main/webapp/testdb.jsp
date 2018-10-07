<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sql:query var="rs" dataSource="jdbc/mysqlantoioviDB">
select automobile_id,marca,modello,targa,descrizione from automobili
</sql:query>

<html>
  <head>
    <title>DB Test</title>
  </head>
  <body>

  <h2>Results</h2>

<c:forEach var="row" items="${rs.rows}">
    Marca       ${row.marca}<br/>
    Modello     ${row.modello}<br/>
    Targa       ${row.targa}<br/>
    Descrizione ${row.descrizione}<br/>
</c:forEach>

  </body>
</html>
