package br.com.projetobiblioteca.dao;

import br.com.projetobiblioteca.model.Biblioteca;
import br.com.projetobiblioteca.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaDAOImpl implements GenericDAO {

    private Connection conn;

    public BibliotecaDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {

        Biblioteca biblioteca = (Biblioteca) object;
        PreparedStatement stmt = null;

        String sql = "Insert into biblioteca(nomebiblioteca, estadobiblioteca, cidadebiblioteca, bairrobiblioteca, ruabiblioteca, numerobiblioteca, cepbiblioteca, telefonebiblioteca, emailbiblioteca) values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, biblioteca.getNomeBiblioteca());
            stmt.setString(2, biblioteca.getEstadoBiblioteca());
            stmt.setString(3, biblioteca.getCidadeBiblioteca());
            stmt.setString(4, biblioteca.getBairroBiblioteca());
            stmt.setString(5, biblioteca.getRuaBiblioteca());
            stmt.setString(6, biblioteca.getNumeroBiblioteca());
            stmt.setString(7, biblioteca.getCepBiblioteca());
            stmt.setString(8, biblioteca.getTelefoneBiblioteca());
            stmt.setString(9, biblioteca.getEmailBiblioteca());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar biblioteca! Erro: " + ex.getMessage());
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
        List<Object> bibliotecas = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from biblioteca;";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Biblioteca biblioteca = new Biblioteca();
                biblioteca.setIdBiblioteca(rs.getInt("idbiblioteca"));
                biblioteca.setNomeBiblioteca(rs.getString("nomebiblioteca"));
                biblioteca.setEstadoBiblioteca(rs.getString("estadobiblioteca"));
                biblioteca.setCidadeBiblioteca(rs.getString("cidadebiblioteca"));
                biblioteca.setBairroBiblioteca(rs.getString("bairrobiblioteca"));
                biblioteca.setRuaBiblioteca(rs.getString("ruabiblioteca"));
                biblioteca.setNumeroBiblioteca(rs.getString("numerobiblioteca"));
                biblioteca.setCepBiblioteca(rs.getString("cepbiblioteca"));
                biblioteca.setTelefoneBiblioteca(rs.getString("telefonebiblioteca"));
                biblioteca.setEmailBiblioteca(rs.getString("emailbiblioteca"));
                bibliotecas.add(biblioteca);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar terrenos! Erro:" + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro" + e.getMessage());
                e.printStackTrace();
            }
        }
        return bibliotecas;
    }

    @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Biblioteca biblioteca = null;
        String sql = "select * from biblioteca where idbiblioteca = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {
                biblioteca = new Biblioteca();
                biblioteca.setIdBiblioteca(rs.getInt("idbiblioteca"));
                biblioteca.setNomeBiblioteca(rs.getString("nomebiblioteca"));
                biblioteca.setEstadoBiblioteca(rs.getString("estadobiblioteca"));
                biblioteca.setCidadeBiblioteca(rs.getString("cidadebiblioteca"));
                biblioteca.setBairroBiblioteca(rs.getString("bairrobiblioteca"));
                biblioteca.setRuaBiblioteca(rs.getString("ruabiblioteca"));
                biblioteca.setNumeroBiblioteca(rs.getString("numerobiblioteca"));
                biblioteca.setCepBiblioteca(rs.getString("cepbiblioteca"));
                biblioteca.setTelefoneBiblioteca(rs.getString("telefoneBiblioteca"));
                biblioteca.setEmailBiblioteca(rs.getString("emailbiblioteca"));;
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar biblioteca! Erro:" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro" + e.getMessage());
                e.printStackTrace();
            }
        }
        return biblioteca;
    }

    @Override
    public Boolean alterar(Object object) {
        Biblioteca biblioteca = (Biblioteca) object;
        PreparedStatement stmt = null;
        String sql = "update biblioteca set nomebiblioteca = ?, estadobiblioteca = ?,"
                + "cidadebiblioteca = ?, bairrobiblioteca = ?, ruabiblioteca = ?, numerobiblioteca = ?,"
                + "cepbiblioteca = ?, telefonebiblioteca = ?, emailbiblioteca = ? where idbiblioteca = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, biblioteca.getNomeBiblioteca());
            stmt.setString(2, biblioteca.getEstadoBiblioteca());
            stmt.setString(3, biblioteca.getCidadeBiblioteca());
            stmt.setString(4, biblioteca.getBairroBiblioteca());
            stmt.setString(5, biblioteca.getRuaBiblioteca());
            stmt.setString(6, biblioteca.getNumeroBiblioteca());
            stmt.setString(7, biblioteca.getCepBiblioteca());
            stmt.setString(8, biblioteca.getTelefoneBiblioteca());
            stmt.setString(9, biblioteca.getEmailBiblioteca());
            stmt.setInt(10, biblioteca.getIdBiblioteca());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao alterar biblioteca! Erro: " + ex.getMessage());
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
    public Boolean excluir(int idOject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
