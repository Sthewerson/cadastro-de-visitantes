package controller;

import dao.VisitanteDAO;
import model.Visitante;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class VisitanteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("🔽 ENTROU NO doPost - Action: " + action);

        try {
            VisitanteDAO dao = new VisitanteDAO();
            String context = request.getContextPath();

            if ("Atualizar".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                String nome = request.getParameter("nome");
                String email = request.getParameter("email");
                String telefone = request.getParameter("telefone");

                System.out.println("✏️ Atualizando visitante ID: " + id);
                Visitante visitante = new Visitante(id, nome, email, telefone);
                dao.update(visitante);

                // redireciona de volta à listagem
                response.sendRedirect(context + "/VisitanteServlet");
            } else {
                String nome = request.getParameter("nome");
                String email = request.getParameter("email");
                String telefone = request.getParameter("telefone");

                System.out.println("➕ Cadastrando novo visitante");
                Visitante visitante = new Visitante(nome, email, telefone);
                dao.create(visitante);

                response.sendRedirect(context + "/VisitanteServlet");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("🔍 ENTROU NO doGet - Action: " + action);

        VisitanteDAO dao = new VisitanteDAO();
        String context = request.getContextPath();

        try {
            if ("edit".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                System.out.println("➡️ Editar ID: " + id);

                Visitante visitante = dao.readById(id);
                request.setAttribute("visitante", visitante);

                // usa path absoluto para o JSP de edição
                request.getRequestDispatcher("/editar.jsp").forward(request, response);

            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                System.out.println("❌ Excluir ID: " + id);

                dao.delete(id);

                // redireciona de volta à listagem
                response.sendRedirect(context + "/VisitanteServlet");

            } else {
                System.out.println("📄 Listar todos");
                List<Visitante> visitantes = dao.readAll();
                request.setAttribute("visitantes", visitantes);

                // usa path absoluto para o JSP de consulta
                request.getRequestDispatcher("/consultar.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}

