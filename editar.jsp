<%@ page import="model.Visitante" %>
<%
    Visitante visitante = (Visitante) request.getAttribute("visitante");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Visitante</title>
</head>
<body>
    <h1>Editar Visitante</h1>

<%
    if (visitante == null) {
%>
    <p style="color:red;">❌ Visitante não encontrado!</p>
<%
    } else {
%>
    <form action="VisitanteServlet" method="post">
        <input type="hidden" name="id" value="<%= visitante.getId() %>">
        <label>Nome:</label><br>
        <input type="text" name="nome" value="<%= visitante.getNome() %>" required><br>
        <label>Email:</label><br>
        <input type="email" name="email" value="<%= visitante.getEmail() %>" required><br>
        <label>Telefone:</label><br>
        <input type="text" name="telefone" value="<%= visitante.getTelefone() %>" required><br><br>
        <input type="submit" name="action" value="Atualizar">
    </form>
<%
    }
%>

</body>
</html>
