package br.com.projetobiblioteca.dao;

import br.com.projetobiblioteca.model.Genero;
import br.com.projetobiblioteca.model.GeneroLivro;
import br.com.projetobiblioteca.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneroLivroDAOImpl implements GenericDAO {

    private Connection conn;

    public GeneroLivroDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        GeneroLivro generolivro = (GeneroLivro) object;
        PreparedStatement stmt = null;

        String sql = "Insert into generolivro(idgenero, idlivro) values (?, ?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, generolivro.getIdGenero().getIdGenero());
            stmt.setInt(2, generolivro.getIdLivro().getIdLivro());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar generos do livro! Erro: " + ex.getMessage());
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
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean excluir(int idOject) {
        PreparedStatement stmt = null;

        String sql = "delete from generolivro where idlivro = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idOject);
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao listar excluir! Erro:" + ex.getMessage());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Object> listarGenero(int idObject) {
        List<Object> generos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select g.* from livro l, genero g, generolivro gl where gl.idlivro = l.idlivro and g.idgenero = gl.idgenero and l.idlivro = ?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Genero genero = new Genero();
                genero.setIdGenero(rs.getInt("idgenero"));
                genero.setNomeGenero(rs.getString("nomegenero"));
                generos.add(genero);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar benfeitorias! Erro:" + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro" + e.getMessage());
                e.printStackTrace();
            }
        }
        return generos;
    }
    
    public List<Object> listarGeneros(int idObject) {
        List<Object> generoslivro = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select g.* from livro l, genero g, generolivro gl where gl.idlivro = l.idlivro and g.idgenero = gl.idgenero and l.idlivro = ?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Genero genero = new Genero();
                genero.setIdGenero(rs.getInt("idgenero"));
                genero.setNomeGenero(rs.getString("nomegenero"));
                generoslivro.add(genero);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar benfeitorias! Erro:" + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro" + e.getMessage());
                e.printStackTrace();
            }
        }
        return generoslivro;
    }

}
