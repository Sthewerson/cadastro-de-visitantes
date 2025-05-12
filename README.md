# Projeto: Cadastro de Visitantes

Aplicação Java Web com JSP, Servlet e JDBC para cadastro, listagem, edição e exclusão de visitantes. Utiliza arquitetura MVC, banco MySQL com Docker e execução manual via Apache Tomcat 9.

---

## ✅ Tecnologias

- Java 17+
- JSP + Servlet
- JDBC + MySQL
- Apache Tomcat 9+
- Docker + Docker Compose (para banco de dados)

---

## 🐳 Como rodar o banco com Docker

1. Vá para a pasta `docker/`:

```bash
cd docker
```

2. Suba o banco de dados:

```bash
docker-compose up -d
```

3. O banco será iniciado com:

- Banco: `visitantes_db`
- Usuário: `visitante`
- Senha: `visitante123`
- Porta: `3307` (evita conflito com instalações locais)

---

## ⚙️ Como rodar o projeto com Tomcat (Linux)

1. Copie o projeto para `/opt/tomcat9/webapps/cadastro-de-visitantes`
2. Compile os arquivos Java:

```bash
cd /opt/tomcat9/webapps/cadastro-de-visitantes/WEB-INF/classes
sudo find . -name "*.java" > sources.txt
sudo javac -cp .:/opt/tomcat9/lib/servlet-api.jar:/opt/tomcat9/lib/mysql-connector-java-8.0.33.jar @sources.txt
```

3. Adicione o arquivo `web.xml` em `WEB-INF/` (já incluso no projeto)
4. Inicie o Tomcat:

```bash
/opt/tomcat9/bin/startup.sh
```

---

## 🌐 Acesso à aplicação

- Listar visitantes:

  ```
  http://localhost:8080/cadastro-de-visitantes/VisitanteServlet
  ```

- Cadastrar novo visitante:

  ```
  http://localhost:8080/cadastro-de-visitantes/cadastrar.jsp
  ```

- Editar/Excluir:
  Clicando nos links dentro da tabela da listagem.

---

## 🧱 Funcionalidades

- ✅ Criar visitantes
- ✅ Listar visitantes
- ✅ Editar visitantes
- ✅ Excluir visitantes
- ✅ Arquitetura MVC com Servlet
- ✅ Banco de dados MySQL via Docker

---

## 📁 Estrutura do projeto

```
cadastro-de-visitantes/
├── docker/
│   ├── docker-compose.yml
│   └── init.sql
├── src/
│   ├── controller/
│   ├── dao/
│   ├── model/
│   └── util/
├── webapp/
│   ├── cadastrar.jsp
│   ├── consultar.jsp
│   └── editar.jsp
├── WEB-INF/
│   ├── classes/
│   └── web.xml
└── README.md
```

---

## 👤 Autor

Desenvolvido por Fernando Sthewerson.
