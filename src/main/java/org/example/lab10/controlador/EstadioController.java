package org.example.lab10.controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lab10.entidad.Estadio;
import org.example.lab10.dao.EstadioDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/estadio", "/estadio/nuevo", "/estadio/del"})
public class EstadioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");

        String action = request.getServletPath();
        EstadioDao estadioDao = new EstadioDao();

        switch (action) {
            case "/estadio":
                ArrayList<Estadio> list = estadioDao.listar();
                request.setAttribute("lista", list);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/estadio/lista.jsp");
                rd.forward(request, response);
                break;
            case "/estadio/nuevo":
                request.getRequestDispatcher("/WEB-INF/estadio/nuevo.jsp").forward(request, response);
                break;
            case "/estadio/del":
                String id = request.getParameter("id");
                Estadio estadio = estadioDao.buscarPorIdEstadio(id);

                if (estadio != null) {
                    try {
                        estadioDao.borrarEstadio(id);
                    } catch (SQLException e) {
                        System.out.println("Log: excepción: " + e.getMessage());
                    }
                }
                response.sendRedirect(request.getContextPath() + "/estadio");
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/lab10");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        EstadioDao estadioDao = new EstadioDao();

        String action = request.getServletPath();

        switch (action) {
            case "/estadio/nuevo":
                String idEstadio = request.getParameter("idEstadio");
                String nombre = request.getParameter("nombre");
                String provincia = request.getParameter("provincia");
                String club = request.getParameter("club");

                if (club == null || club.isEmpty()) {
                    club = null;
                }

                Estadio estadio = estadioDao.buscarPorIdEstadio(idEstadio);

                if (estadio == null) {
                    estadioDao.crearEstadio(idEstadio, nombre, provincia, club);
                    response.sendRedirect(request.getContextPath() + "/estadio");
                } else {
                    request.getRequestDispatcher("/WEB-INF/estadio/nuevo.jsp").forward(request, response);
                }
                break;
        }
    }
}
