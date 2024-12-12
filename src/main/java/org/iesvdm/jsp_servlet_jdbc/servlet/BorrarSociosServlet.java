package org.iesvdm.jsp_servlet_jdbc.servlet;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesvdm.jsp_servlet_jdbc.dao.SocioDAO;
import org.iesvdm.jsp_servlet_jdbc.dao.SocioDAOImpl;
import org.iesvdm.jsp_servlet_jdbc.model.Socio;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "/BorrarSociosServlet", value = "/BorrarSociosServlet")
public class BorrarSociosServlet extends HttpServlet {

    private SocioDAO socioDAO = new SocioDAOImpl();

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Creamos un objeto RequestDispatcher para luego redirigir a la página de listado de socios
        RequestDispatcher dispatcher = null;

        // Recogemos el codigo del socio a borrar
        int nsocio = Integer.parseInt(request.getParameter("codigo"));

        // El find de la interfaz SocioDAO nos devuelve un Optional de Socio
        // Si el socio existe lo borramos y sino damos un mensaje de error
        Optional<Socio> socioOptional = this.socioDAO.find(nsocio);

        if (socioOptional.isPresent()) {
            Socio socio = socioOptional.get(); // Obtenemos el socio del Optional porque sabemos que está presente
            this.socioDAO.delete(socio.getSocioId()); // Borramos el socio

            // Redirigimos a la página de listado de socios pero antes actualizamos la lista de socios
            List<Socio> listado = this.socioDAO.getAll();
            request.setAttribute("listado", listado);
            request.setAttribute("ID Socio Eliminado", nsocio);

            // Redirigimos a la página de listado de socios
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listadoSociosB.jsp");
        } else {
            // Si el optional no está presente, es decir, no existe el socio con ese codigo
            // Entonces redirigimos a la página de listado de socios con un mensaje de error
            request.setAttribute("error", "No existe el socio con el codigo: " + nsocio);
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listadoSociosB.jsp");
        }

        dispatcher.forward(request, response); // Hacemos la redirección interna en el servidor a la página de listado de socios
        // con la lista de socios actualizada
    }
}