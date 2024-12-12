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

@WebServlet(name = "EditarSociosServlet", value = "/EditarSociosServlet")
public class EditarSociosServlet extends HttpServlet {

    private SocioDAO socioDAO = new SocioDAOImpl();

    // Maneja las solicitudes GET para obtener los datos del socio y enviarlos al formulario de edición
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int codigoSocio = Integer.parseInt(request.getParameter("codigo"));

            Optional<Socio> socioOptional = this.socioDAO.find(codigoSocio);

            if (socioOptional.isPresent()) {
                request.setAttribute("editarSocio", socioOptional.get());
            } else {
                request.setAttribute("error", "No se encontró un socio con el código: " + codigoSocio);
                request.getRequestDispatcher("/WEB-INF/jsp/listadoSociosB.jsp").forward(request, response);
                return;
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/formularioEditarSocio.jsp");
            dispatcher.forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Código de socio no válido.");
            request.getRequestDispatcher("/WEB-INF/jsp/listadoSociosB.jsp").forward(request, response);
        }
    }

    // Maneja las solicitudes POST para actualizar los datos del socio
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigoSocio;
        try {
            codigoSocio = Integer.parseInt(request.getParameter("codigo"));
        } catch (NumberFormatException e) {
            request.setAttribute("error", "El código del socio no es válido.");
            request.getRequestDispatcher("/WEB-INF/jsp/formularioEditarSocio.jsp").forward(request, response);
            return;
        }

        Optional<Socio> socioExistente = this.socioDAO.find(codigoSocio);
        if (!socioExistente.isPresent()) {
            request.setAttribute("error", "No existe un socio con el código: " + codigoSocio);
            request.getRequestDispatcher("/WEB-INF/jsp/formularioEditarSocio.jsp").forward(request, response);
            return;
        }

        Optional<Socio> socioValidado = UtilServlet.validaGrabar(request);
        if (socioValidado.isPresent()) {
            Socio socioActualizado = socioValidado.get();
            socioActualizado.setSocioId(codigoSocio);

            this.socioDAO.update(socioActualizado);

            List<Socio> listadoSocios = this.socioDAO.getAll();
            request.setAttribute("listado", listadoSocios);
            request.getRequestDispatcher("/WEB-INF/jsp/listadoSociosB.jsp").forward(request, response);

        } else {
            request.setAttribute("error", "Error en los datos del formulario. Revise e intente nuevamente.");
            request.setAttribute("editarSocio", socioExistente.get());
            request.getRequestDispatcher("/WEB-INF/jsp/formularioEditarSocio.jsp").forward(request, response);
        }
    }
}
