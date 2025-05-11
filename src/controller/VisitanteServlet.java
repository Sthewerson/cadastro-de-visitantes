package controller;

import dao.VisitanteDAO;
import model.Visitante;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/VisitanteServlet")
public class VisitanteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");

        Visitante visitante = new Visitante(nome, email, telefone);
        try {
            VisitanteDAO dao = new VisitanteDAO();
            dao.create(visitante);
            response.sendRedirect("VisitanteServlet");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            VisitanteDAO dao = new VisitanteDAO();
            List<Visitante> visitantes = dao.readAll();
            request.setAttribute("visitantes", visitantes);
            request.getRequestDispatcher("consultar.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}