package br.com.projetobiblioteca.dao;

import br.com.projetobiblioteca.model.Biblioteca;
import br.com.projetobiblioteca.model.Livro;
import br.com.projetobiblioteca.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAOImpl implements GenericDAO {

    private Connection conn;

    public LivroDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Integer cadastrarLivro(Object object) {
        Livro livro = (Livro) object;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer idLivro = null;

        String sql = "Insert into livro(titulolivro, autorlivro, editoralivro, anolivro, isbnlivro, valorlivro, quantidadelivro, idbiblioteca) values (?, ?, ?, ?, ?, ?, ?, ?) returning idlivro;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, livro.getTituloLivro());
            stmt.setString(2, livro.getAutorLivro());
            stmt.setString(3, livro.getEditoraLivro());
            stmt.setString(4, livro.getAnoLivro());
            stmt.setString(5, livro.getIsbnLivro());
            stmt.setDouble(6, livro.getValorLivro());
            stmt.setInt(7, livro.getQuantidadeLivro());
            stmt.setInt(8, livro.getIdBiblioteca().getIdBiblioteca());
            rs = stmt.executeQuery();

            if (rs.next()) {
                idLivro = rs.getInt("idlivro");
            }
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar livro! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return idLivro;
    }

    public Integer alterarLivro(Object object) {
        Livro livro = (Livro) object;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer idLivro = null;
        String sql = "update livro set titulolivro = ?, autorlivro = ?,"
                + "editoralivro = ?, anolivro = ?, isbnlivro = ?, valorlivro = ?,"
                + "quantidadelivro = ? where idlivro = ? returning idlivro;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, livro.getTituloLivro());
            stmt.setString(2, livro.getAutorLivro());
            stmt.setString(3, livro.getEditoraLivro());
            stmt.setString(4, livro.getAnoLivro());
            stmt.setString(5, livro.getIsbnLivro());
            stmt.setDouble(6, livro.getValorLivro());
            stmt.setInt(7, livro.getQuantidadeLivro());
            stmt.setInt(8, livro.getIdLivro());
            stmt.executeUpdate();
            rs = stmt.executeQuery();

            if (rs.next()) {
                idLivro = rs.getInt("idlivro");
            }
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar livro! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return idLivro;
    }

    @Override
    public List<Object> listar() {
        List<Object> livros = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from livro;";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Livro livro = new Livro();
                livro.setIdLivro(rs.getInt("idlivro"));
                livro.setTituloLivro(rs.getString("titulolivro"));
                livro.setAutorLivro(rs.getString("autorlivro"));
                livro.setEditoraLivro(rs.getString("editoralivro"));
                livro.setAnoLivro(rs.getString("anolivro"));
                livro.setIsbnLivro(rs.getString("isbnlivro"));
                livro.setValorLivro(rs.getDouble("valorlivro"));
                livro.setQuantidadeLivro(rs.getInt("quantidadelivro"));
                livros.add(livro);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar livros! Erro:" + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro" + e.getMessage());
                e.printStackTrace();
            }
        }
        return livros;
    }

    @Override
    public Boolean excluir(int idOject) {
        PreparedStatement stmt = null;

        String sql = "delete from compra where idlivro = ?;"
                + "commit;"
                + "delete from generolivro where idlivro = ?;"
                + "commit;"
                + "delete from livro where idlivro=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idOject);
            stmt.setInt(2, idOject);
            stmt.setInt(3, idOject);
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao listar bibliotecario! Erro:" + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexÃ£o! Erro:" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Livro livro = null;
        String sql = "select * from livro where idlivro = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {
                livro = new Livro();
                livro.setIdLivro(rs.getInt("idlivro"));
                livro.setTituloLivro(rs.getString("titulolivro"));
                livro.setAutorLivro(rs.getString("autorlivro"));
                livro.setEditoraLivro(rs.getString("editoralivro"));
                livro.setAnoLivro(rs.getString("anolivro"));
                livro.setIsbnLivro(rs.getString("isbnlivro"));
                livro.setValorLivro(rs.getDouble("valorlivro"));
                livro.setQuantidadeLivro(rs.getInt("quantidadelivro"));
                livro.setIdBiblioteca(new Biblioteca(rs.getInt("idbiblioteca")));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar livro! Erro:" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro" + e.getMessage());
                e.printStackTrace();
            }
        }
        return livro;
    }

    @Override
    public Boolean alterar(Object object) {
        Livro livro = (Livro) object;
        PreparedStatement stmt = null;
        String sql = "update livro set titulolivro = ?, autorlivro = ?,"
                + "editoralivro = ?, anolivro = ?, isbnlivro = ?, valorlivro = ?,"
                + "quantidadelivro = ? where idlivro = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, livro.getTituloLivro());
            stmt.setString(2, livro.getAutorLivro());
            stmt.setString(3, livro.getEditoraLivro());
            stmt.setString(4, livro.getAnoLivro());
            stmt.setString(5, livro.getIsbnLivro());
            stmt.setDouble(6, livro.getValorLivro());
            stmt.setInt(7, livro.getQuantidadeLivro());
            stmt.setInt(8, livro.getIdLivro());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao alterar livro! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object listarLivro(int idBiblioteca) {
        List<Object> livros = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Livro livro = null;
        String sql = "select * from livro where idbiblioteca = ?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idBiblioteca);
            rs = stmt.executeQuery();

            while (rs.next()) {
                livro = new Livro();
                livro.setIdLivro(rs.getInt("idlivro"));
                livro.setTituloLivro(rs.getString("titulolivro"));
                livro.setAutorLivro(rs.getString("autorlivro"));
                livro.setEditoraLivro(rs.getString("editoralivro"));
                livro.setAnoLivro(rs.getString("anolivro"));
                livro.setIsbnLivro(rs.getString("isbnlivro"));
                livro.setValorLivro(rs.getDouble("valorlivro"));
                livro.setQuantidadeLivro(rs.getInt("quantidadelivro"));
                livros.add(livro);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar livros! Erro:" + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro" + e.getMessage());
                e.printStackTrace();
            }
        }
        return livros;
    }
}
