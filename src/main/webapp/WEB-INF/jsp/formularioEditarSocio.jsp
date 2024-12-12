<%@ page import="org.iesvdm.jsp_servlet_jdbc.model.Socio" %><%--
  Created by IntelliJ IDEA.
  User: cesar
  Date: 10/12/2024
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="estilos.css" />
</head>
<body class="bg-light">
<div class="container bg-white">
    <div class="row border-bottom">
        <div class="col-12 h2">Modifica los datos del socio</div>
    </div>
</div>


<%
    // RECOGER EL SOCIO DEL ÁMBITO request
    Socio editarSocio = (Socio) request.getAttribute("editarSocio");
%>

<div class="container bg-light">
    <form method="post" action="EditarSociosServlet">
        <div class="row body mt-2">
            <div class="col-md-6 align-self-center">Nombre</div>
            <div class="col-md-6 align-self-center"><input type="text" name="nombre" value="<%=editarSocio.getNombre()%>"/></div>
        </div>
        <div class="row body mt-2">
            <div class="col-md-6 align-self-center">Estatura</div>
            <div class="col-md-6 align-self-center"><input type="text" name="estatura" value="<%=editarSocio.getEstatura()%>"/></div>
        </div>
        <div class="row body mt-2">
            <div class="col-md-6 align-self-center">Edad</div>
            <div class="col-md-6 align-self-center"><input type="text" name="edad" value="<%=editarSocio.getEdad()%>" /></div>
        </div>
        <div class="row body mt-2">
            <div class="col-md-6 align-self-center">Localidad</div>
            <div class="col-md-6 align-self-center"><input type="text" name="localidad" value="<%=editarSocio.getLocalidad()%>"/></div>
        </div>
        <div class="row mt-2">
            <div class="col-md-6">
                &nbsp;
            </div>
            <div class="col-md-6 align-self-center">
                <input type="hidden" name="codigo" value="<%=editarSocio.getSocioId()%>"/>
                <input class="btn btn-primary" type="submit" value="Aceptar">
            </div>
        </div>
    </form>
    <%
        //                                                 v---- RECOGER MENSAJE DE ERROR DEL ÁMBITO request
        String error = (String) request.getAttribute("error");
//            v---- SI ESTÁ PRESENTE INFORMAR DEL ERROR
        if (error != null) {
    %>
    <div class="row mt-2">
        <div class="col-6">
            <div class="alert alert-danger alert-dismissible fade show">
                <strong>Error!</strong> <%=error%>
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            </div>
        </div>
    </div>
    <%
        }
    %>
</div>
<script src="js/bootstrap.bundle.js" ></script>
</body>
</html>