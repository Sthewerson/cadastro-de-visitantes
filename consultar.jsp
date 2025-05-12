<%@ page import="java.util.List" %>
<%@ page import="model.Visitante" %>
<%
    List<Visitante> visitantes = (List<Visitante>) request.getAttribute("visitantes");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Visitantes</title>
</head>
<body>
    <h1>Visitantes Cadastrados</h1>
    <table border="1">
        <tr>
            <th>ID</th><th>Nome</th><th>Email</th><th>Telefone</th><th>Ações</th>
        </tr>
        <%
            if (visitantes != null) {
                for (Visitante v : visitantes) {
        %>
        <tr>
            <td><%= v.getId() %></td>
            <td><%= v.getNome() %></td>
            <td><%= v.getEmail() %></td>
            <td><%= v.getTelefone() %></td>
            <td>
                <a href="VisitanteServlet?action=edit&id=<%= v.getId() %>">Editar</a> |
                <a href="VisitanteServlet?action=delete&id=<%= v.getId() %>" onclick="return confirm('Tem certeza que deseja excluir?')">Excluir</a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <br>
    <a href="cadastrar.jsp">Cadastrar Novo Visitante</a>
</body>
</html>

