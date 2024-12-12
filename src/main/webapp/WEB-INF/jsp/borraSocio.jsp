<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
    <%
    //CÓDIGO DE VALIDACIÓN
    boolean valida = true;
    int codigo = -1;
    try {
    	codigo = Integer.parseInt(request.getParameter("codigo"));
    } catch (NumberFormatException nfe) {
    	nfe.printStackTrace();
    	valida = false;
    }
    //FIN CÓDIGO DE VALIDACIÓN
    
    
    if (valida) {

      
	Connection conn = null;
	PreparedStatement ps = null;
// 	ResultSet rs = null;

	 try {
		 
		//CARGA DEL DRIVER Y PREPARACIÓN DE LA CONEXIÓN CON LA BBDD
		//						v---------UTILIZAMOS LA VERSIÓN MODERNA DE LLAMADA AL DRIVER
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/baloncesto","root", "secret");
		
//>>>>>>NO UTILIZAR STATEMENT EN QUERIES PARAMETRIZADAS
//      Statement s = conexion.createStatement();
//      s.execute ("DELETE FROM socio WHERE socioID=" + request.getParameter("codigo"));
//<<<<<<
		 
		//UTILIZAR PreparedStatement SIEMPRE EN QUERIES PARAMETRIZADAS
		//EN ESTE CASO 1 SOLO PARÁMETRO: socioID = ?
		//NÓTESE QUE EL PARÁMETRO SE INTRODUCE CON UN CARÁCTER ?
		String sql = "DELETE FROM socio WHERE socioID = ?";
		//CREO EL OBJETO PreparedStatement
		ps = conn.prepareStatement(sql);
		
		//A LA HORA DE ESTABLECER EL VALOR DEL PARÁMETRO PARA PODER EJECUTAR 
		//LA QUERY DEBEMOS INDICAR LA POSICIÓN Y UTILIZAR EL SETTER DE TIPO ADECUADO
		ps.setInt(1, codigo);
		
		//CUANDO EJECUTAS SENTENCIAS DML, INSERT, UPDATE, DELETE SE EMPLEA ps.executeUpdate()
		int filasAfectadas = ps.executeUpdate();
		
		System.out.println("SOCIOS BORRADOS:  " + filasAfectadas);
		  
	 } catch (Exception ex) {
		 ex.printStackTrace();
	 } finally {
		//BLOQUE FINALLY PARA CERRAR LA CONEXIÓN CON PROTECCIÓN DE try-catch
		//SIEMPRE HAY QUE CERRAR LOS ELEMENTOS DE LA  CONEXIÓN DESPUÉS DE UTILIZARLOS
		    //try { rs.close(); } catch (Exception e) { /* Ignored */ }
		    try { ps.close(); } catch (Exception e) { /* Ignored */ }
		    try { conn.close(); } catch (Exception e) { /* Ignored */ }
	 }
	  
    }
    %>
    
    <!-- REDIRECCIÓN POR JavaScript EN EL CLIENTE  -->
    <script>document.location = "pideNumeroSocio.jsp"</script> 
  </body>
</html>