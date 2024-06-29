package org.example.lab10.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/lab10", "/lab10/jugador", "/lab10/estadio"})
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");

        String action = request.getServletPath();

        switch (action) {
            case "/lab10":
                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                break;
            case "/lab10/jugador":
                response.sendRedirect(request.getContextPath() + "/jugador");
                break;
            case "/lab10/estadio":
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
        doGet(request, response);
    }
}
