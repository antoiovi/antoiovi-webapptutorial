<html>
<body>
<h2>Hello World!</h2>
<jsp:useBean id = "date" class = "java.util.Date" />
<jsp:useBean id = "msgbean" class = "com.antoiovi.b1botstr.HelloBean" />
<p>The date/time is <%= date %>
  <p>Messaggio di saluto:
n style="color: #007700"><jsp:getProperty name = "msgbean" property = "message"/>
   </p>
<ul>
      <li><a href="pagina1.xhtml">pagina 1</a></li>
      <li><a href="pagina2.xhtml">pagina 2</a></li>
      <li><a href="helloboot.xhtml">helloboot.xhtml</a></li>
      <li><a href="login.xhtml">login.xhtml</a></li>
      <li><a href="bforms.xhtml">bforms.xhtml</a></li>
</ul>

</body>
</html>
