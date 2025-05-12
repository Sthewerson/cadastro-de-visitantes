package dao;

import model.Visitante;
import util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisitanteDAO {

    public void create(Visitante visitante) throws SQLException {
        String sql = "INSERT INTO visitantes (nome, email, telefone) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, visitante.getNome());
            stmt.setString(2, visitante.getEmail());
            stmt.setString(3, visitante.getTelefone());
            stmt.executeUpdate();
        }
    }

    public List<Visitante> readAll() throws SQLException {
        List<Visitante> lista = new ArrayList<>();
        String sql = "SELECT * FROM visitantes";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Visitante v = new Visitante(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("telefone")
                );
                lista.add(v);
            }
        }
        return lista;
    }

    public Visitante readById(int id) throws SQLException {
        String sql = "SELECT * FROM visitantes WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Visitante(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("telefone")
                );
            }
        }
        return null;
    }

    public void update(Visitante visitante) throws SQLException {
        String sql = "UPDATE visitantes SET nome=?, email=?, telefone=? WHERE id=?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, visitante.getNome());
            stmt.setString(2, visitante.getEmail());
            stmt.setString(3, visitante.getTelefone());
            stmt.setInt(4, visitante.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM visitantes WHERE id=?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

