# Projeto: Cadastro de Visitantes

Este projeto Java Web (JSP + Servlet + JDBC) realiza o cadastro e a consulta de visitantes, utilizando arquitetura MVC e banco de dados MySQL via Docker.

---

## ✅ Tecnologias

- Java 11+
- JSP + Servlet
- JDBC + MySQL
- Apache Tomcat 9+
- Docker + Docker Compose

---

## 🐳 Como rodar o banco com Docker

1. Acesse a pasta `docker`:
```bash
cd docker
```

2. Suba o container MySQL:
```bash
docker-compose up -d
```

3. O banco será iniciado com os dados:
- Banco: `visitantes_db`
- Usuário: `visitante`
- Senha: `visitante123`
- Porta: `3306`

4. Tabela criada automaticamente com:
```sql
CREATE TABLE IF NOT EXISTS visitantes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  telefone VARCHAR(20) NOT NULL
);
```

---

## ⚙️ Como rodar o projeto

### Eclipse (Dynamic Web Project)

1. Importe o projeto no Eclipse.
2. Certifique-se que os `.java` estão em `src/`.
3. Copie o conteúdo de `webapp/` para `WebContent/`.
4. Adicione o driver JDBC:
   - Baixe `mysql-connector-java-8.x.x.jar`
   - Copie para `lib/` do Tomcat e adicione no `build path`

### Ou pelo terminal (compilando manualmente)

1. Compile os `.java`:
```bash
javac -cp lib/mysql-connector-java-8.x.x.jar -d build src/**/*.java
```

2. Copie arquivos `.class` e `.jsp` para seu diretório do Tomcat (`webapps/`).

---

## 🌐 Acesso à aplicação

Após iniciar o Tomcat:

- Formulário de cadastro:
  ```
  http://localhost:8080/cadastro-de-visitantes/cadastrar.jsp
  ```

- Listagem de visitantes:
  ```
  http://localhost:8080/cadastro-de-visitantes/VisitanteServlet
  ```

---

## 📁 Estrutura

```
cadastro-de-visitantes/
├── docker/
│   ├── docker-compose.yml
│   └── init.sql
├── src/
│   ├── controller/VisitanteServlet.java
│   ├── dao/VisitanteDAO.java
│   ├── model/Visitante.java
│   └── util/Conexao.java
├── webapp/
│   ├── cadastrar.jsp
│   └── consultar.jsp
└── README.md
```

---

## Autor

Desenvolvido por Fernando Sthewerson.