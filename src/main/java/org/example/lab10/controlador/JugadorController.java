package org.example.lab10.controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lab10.entidad.Jugador;
import org.example.lab10.dao.JugadorDao;
import org.example.lab10.dao.SeleccionDao;
import org.example.lab10.entidad.Seleccion;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/jugador", "/jugador/nuevo", "/jugador/del"})
public class JugadorController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");

        String action = request.getServletPath();
        JugadorDao jugadorDao = new JugadorDao();
        SeleccionDao seleccionDao = new SeleccionDao();

        switch (action) {
            case "/jugador":
                ArrayList<Jugador> list = jugadorDao.listar();
                request.setAttribute("lista", list);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jugador/lista.jsp");
                rd.forward(request, response);
                break;
            case "/jugador/nuevo":
                ArrayList<Seleccion> selecciones = seleccionDao.listar();
                request.setAttribute("selecciones", selecciones);
                request.getRequestDispatcher("/WEB-INF/jugador/nuevo.jsp").forward(request, response);
                break;
            case "/jugador/del":
                String id = request.getParameter("id");
                Jugador jugador = jugadorDao.buscarPorId(id);

                if (jugador != null) {
                    try {
                        jugadorDao.borrar(id);
                    } catch (SQLException e) {
                        System.out.println("Log: excepción: " + e.getMessage());
                    }
                }
                response.sendRedirect(request.getContextPath() + "/jugador");
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/jugador");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        JugadorDao jugadorDao = new JugadorDao();

        String action = request.getServletPath();

        switch (action) {
            case "/jugador/nuevo":
                String idJugador = request.getParameter("idJugador");
                String nombre = request.getParameter("nombre");
                String edad = request.getParameter("edad");
                String posicion = request.getParameter("posicion");
                String club = request.getParameter("club");
                String seleccionNacional = request.getParameter("seleccion");

                Jugador jugador = jugadorDao.buscarPorId(idJugador);

                if (jugador == null) {
                    jugadorDao.crear(idJugador, nombre, Integer.parseInt(edad), posicion, club, Integer.parseInt(seleccionNacional));
                    response.sendRedirect(request.getContextPath() + "/jugador");
                } else {
                    ArrayList<Seleccion> selecciones = new SeleccionDao().listar();
                    request.setAttribute("selecciones", selecciones);
                    request.setAttribute("error", "Jugador ya existe con ese ID.");
                    request.getRequestDispatcher("/WEB-INF/jugador/nuevo.jsp").forward(request, response);
                }
                break;
        }
    }
}
