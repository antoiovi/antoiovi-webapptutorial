<html>
<body>
<h2>Hello World!</h2>
<jsp:useBean id = "date" class = "java.util.Date" />
<jsp:useBean id = "msgbean" class = "com.antoiovi.b1botstr.HelloBean" />
<p>The date/time is <%= date %>
  <p>Messaggio di saluto:
n style="color: #007700"><jsp:getProperty name = "msgbean" property = "message"/>
   </p>
</body>
</html>
