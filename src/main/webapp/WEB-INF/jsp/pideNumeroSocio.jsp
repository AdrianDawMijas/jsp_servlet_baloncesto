<%@ page import="java.sql.*" %>
<%@ page import="org.iesvdm.jsp_servlet_jdbc.model.Socio" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="estilos.css" />
  </head>
  <body>
    <table>
      <tr><th>Código</th><th>Nombre</th><th>Estatura</th><th>Edad</th><th>Localidad</th></tr>
    <%
//                                                              v----RECOGER listado DE SOCIO DEL request --%>
        List<Socio> listado = (List<Socio>) request.getAttribute("listado");

//      FOR-EACH SOBRE LA COLECCIÓN DE listado DE SOCIO--%>
        for(Socio socio: listado) {
          %>
      <tr>
<%--           v--- EXPRESIÓN ACCEDIENDO A LOS VALORES DE SOCIO--%>
        <td><%=socio.getSocioId() %>
        </td>
        <td><%=socio.getNombre() %>
        </td>
        <td><%=socio.getEdad() %>
        </td>
        <td><%=socio.getEstatura() %>
        </td>
        <td><%= socio.getLocalidad()%>
        </td>

      <td>
      <form method="get" action="borraSocio.jsp">
        <input type="hidden" name="codigo" value="<%=socio.getSocioId() %>"/>
        <input type="submit" value="Borrar">
      </form>
      </td></tr>
    <%

<%--    v--- FIN DEL BUCLE FOR CON HTML INCRUSTADO--%>
      } // for
     %>
    </table>
  </body>
</html>