<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Visitante</title>
</head>
<body>
    <h1>Cadastro de Visitante</h1>
    <form action="VisitanteServlet" method="post">
        <label>Nome:</label><br>
        <input type="text" name="nome" required><br>
        <label>Email:</label><br>
        <input type="email" name="email" required><br>
        <label>Telefone:</label><br>
        <input type="text" name="telefone" required><br><br>
        <input type="submit" value="Cadastrar">
    </form>
    <br>
    <a href="VisitanteServlet">Ver Visitantes</a>
</body>
</html>